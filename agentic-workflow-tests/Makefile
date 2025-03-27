# test
TEST_NBR ?= 0001
TEST_ROOT_DIR := $(dir $(realpath $(firstword $(MAKEFILE_LIST))))
TEST_DIR := $(TEST_ROOT_DIR)/$(TEST_NBR)

# tools
FORMAT = $(TEST_ROOT_DIR)/utils/format-llm-eval-context.sh

# keys
AZURE_API_KEY ?= unset
OPENAI_API_KEY ?= unset

# tested project
PRJ_DIR ?= ../../golf-application
GIT_DIR := $(PRJ_DIR)/.git
BASE_COMMIT ?= b79e68d210c52154bb51b7217de4a22ea66a15d4
COMMIT2 ?= HEAD
COMMIT1 != echo -n HEAD~`git -C $(PRJ_DIR) rev-list --count $(BASE_COMMIT)..$(COMMIT2)`


format_changes:
	GIT_DIR=$(PRJ_DIR)/.git $(FORMAT) $(COMMIT1) $(COMMIT2) $(TEST_DIR)/TestSpec.xml > $(TEST_DIR)/changes.md

assemble: format_changes

test:
	@echo TEST_ROOT_DIR=$(TEST_ROOT_DIR)
	@echo PRJ_DIR=$(PRJ_DIR)
	@echo COMMIT1=$(COMMIT1)

.PHONY: assemble
.PHONY: format_changes
