#!/usr/bin/env bash

if type -p /opt/homebrew/bin/ccache >/dev/null 2>&1; then
  CCACHE=/opt/homebrew/bin/ccache
elif type -p /usr/local/bin/ccache >/dev/null 2>&1; then
  CCACHE=/usr/local/bin/ccache
fi

if [ -n ${CCACHE+x} ]; then
  export CCACHE_CPP2="true"
  export CCACHE_DEPEND="true"
  export CCACHE_DIRECT="true"
  export CCACHE_FILECLONE="true"
  export CCACHE_INODECACHE="true"
  export CCACHE_MAXSIZE="10G"
  export CCACHE_NOPCH_EXTSUM="true"
  export CCACHE_SLOPPINESS="clang_index_store, file_stat_matches, include_file_ctime, include_file_mtime, ivfsoverlay, modules, pch_defines, system_headers, time_macros"

  exec $CCACHE "$@"
else
  exec "$@"
fi
