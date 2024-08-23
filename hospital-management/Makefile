# Variables
SERVICES = api-gateway appointment-service case-service directory-service patient-service
LIB_PROJECT = hospital-management-console
REPO_URL = https://github.com/tambenikita391/the-mono-repo.git

# Default target
all: clone git_status git_pull git_stash build_lib build_services build_images push_images

# Clone all services and the JavaFX project with lib
clone:
	@echo "Cloning all services and JavaFX project with lib..."
	@for service in $(SERVICES); do \
		git clone $(REPO_URL) $$service; \
	done
	@git clone $(REPO_URL) $(LIB_PROJECT)

# Print Git status of all projects
git_status:
	@echo "Printing Git status of all projects..."
	@for project in $(SERVICES) $(LIB_PROJECT); do \
		(cd $$project && git status); \
	done

# Git pull for all projects
git_pull:
	@echo "Pulling latest changes for all projects..."
	@for project in $(SERVICES) $(LIB_PROJECT); do \
		(cd $$project && git pull); \
	done

# Git stash for all projects
git_stash:
	@echo "Stashing changes for all projects..."
	@for project in $(SERVICES) $(LIB_PROJECT); do \
		(cd $$project && git stash); \
	done

# Build the library project (JavaFX project with lib)
build_lib:
	@echo "Building JavaFX library project..."
	@(cd $(LIB_PROJECT) && mvn clean install)

# Build all services
build_services:
	@echo "Building all services..."
	@for service in $(SERVICES); do \
		(cd $$service && mvn clean install); \
	done

# Build Docker images for all services
build_images:
	@echo "Building Docker images for all services..."
	@for service in $(SERVICES); do \
		(cd $$service && docker build -t your-dockerhub-username/$$service .); \
	done

# Push Docker images to Docker Hub
push_images:
	@echo "Pushing Docker images to Docker Hub..."
	@for service in $(SERVICES); do \
		docker push your-dockerhub-username/$$service; \
	done

