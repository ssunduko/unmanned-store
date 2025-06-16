# Unmanned Store

This project implements an autonomous, always-open retail store using a vertical slice architecture. Each feature is developed as an independent vertical slice, from API to database, with a focus on real-time IoT integration, reliability, and scalability.

## Technologies
- Spring Boot 3.x, Spring Cloud
- Java 17+
- PostgreSQL (feature-specific schemas)
- Redis
- Amazon EventBridge
- REST API (OpenAPI 3.0)
- AWS IoT Core (MQTT)
- CloudWatch, Prometheus

## Structure
- `src/main/java/com/unmannedstore/features/` — Feature-centric vertical slices
- `src/main/resources/` — Configuration and resources
- `kubernetes/`, `scripts/` — Deployment and automation

## Example Feature: Shopping Management
Implements real-time basket updates, product add/remove, and running total calculation, with IoT integration for RFID and shelf sensors.

See `markdown/unmanned-store-vertical-slice-package-structure.md` for the full package structure. 