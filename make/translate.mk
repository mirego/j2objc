# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Defines the "translate" target.
#
# The including makefile must define the variables:
#   TRANSLATE_JAVA_FULL
#   TRANSLATE_JAVA_RELATIVE
# And optional variables:
#   TRANSLATE_ARGS
#
# Author: Keith Stanger

TRANSLATE_SOURCES = $(TRANSLATE_JAVA_RELATIVE:%.java=$(GEN_OBJC_DIR)/%.m)
TRANSLATE_HEADERS = $(TRANSLATE_SOURCES:.m=.h)
TRANSLATE_OBJC = $(TRANSLATE_SOURCES) $(TRANSLATE_HEADERS)
TRANSLATE_TARGET = $(BUILD_DIR)/.translate_mark
TRANSLATE_EXE = $(DIST_DIR)/j2objc
TRANSLATE_CMD = $(TRANSLATE_EXE) -d $(GEN_OBJC_DIR) $(TRANSLATE_ARGS)

translate: $(TRANSLATE_TARGET)
	@:

TRANSLATE_MAKE_LIST = $(if $(filter $(TRANSLATE_EXE),$?),\
    $(filter-out $(TRANSLATE_EXE),$^),\
    $(filter-out $(TRANSLATE_EXE),$?))

$(TRANSLATE_TARGET): $(TRANSLATE_JAVA_FULL) $(TRANSLATE_EXE)
	@echo Translating sources.
	@mkdir -p $(GEN_OBJC_DIR)
	@$(TRANSLATE_CMD) $(TRANSLATE_MAKE_LIST)
	@touch $@

$(TRANSLATE_OBJC): $(TRANSLATE_TARGET)
	@:
