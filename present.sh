#!/bin/sh

killport() {
	local pid=`lsof  -i :$1 | grep LISTEN | awk '{print $2}'`
	if [ -n $pid ]; then
		kill $pid
	fi
}

killport 8000
python -m SimpleHTTPServer >/dev/null 2>&1 &
open http://localhost:8000/dropwizard.html
