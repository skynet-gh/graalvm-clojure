(defproject simple "0.1.0-SNAPSHOT"

  :managed-dependencies
  [[io.netty/netty-codec-http "4.1.39.Final"]
   [io.netty/netty-codec "4.1.39.Final"]
   [io.netty/netty-handler-proxy "4.1.39.Final"]
   [io.netty/netty-codec-socks "4.1.39.Final"]
   [io.netty/netty-handler "4.1.39.Final"]
   [io.netty/netty-resolver-dns "4.1.39.Final"]
   [io.netty/netty-codec-dns "4.1.39.Final"]
   [io.netty/netty-resolver "4.1.39.Final"]
   [io.netty/netty-transport-native-epoll "4.1.39.Final"]
   [io.netty/netty-common "4.1.39.Final"]
   [io.netty/netty-transport-native-unix-common "4.1.39.Final"]
   [io.netty/netty-transport "4.1.39.Final"]
   [io.netty/netty-buffer "4.1.39.Final"]]


  :dependencies [[org.clojure/clojure "1.11.0"]
                 [aleph "0.4.7"]]
  :main simple.main
  :uberjar-name "simple-main.jar"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[lein-shell "0.5.0"]]}}

  :aliases
  {"native"
   ["shell"
    "native-image" "--report-unsupported-elements-at-runtime" "--no-server" "--no-fallback"
    "-H:+ReportExceptionStackTraces"
    "--initialize-at-build-time"
    "--initialize-at-run-time=io.netty.channel.epoll.EpollEventArray"
    "--initialize-at-run-time=io.netty.channel.unix.Errors"
    "--initialize-at-run-time=io.netty.channel.unix.IovArray"
    "--initialize-at-run-time=io.netty.channel.unix.Socket"
    "--initialize-at-run-time=io.netty.channel.epoll.Native"
    "--initialize-at-run-time=io.netty.channel.epoll.EpollEventLoop"
    "--initialize-at-run-time=io.netty.util.internal.logging.Log4JLogger"
    "--initialize-at-run-time=io.netty.channel.unix.Limits"
    "--allow-incomplete-classpath"
    "-jar" "./target/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
    "-H:Name=./target/${:name}"]

   "run-native" ["shell" "./target/${:name}"]})
