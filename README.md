# 🚚 logistics-platform

## 📅 프로젝트 진행 기간

2024.12.05 - 2024.12.17 (13일 동안 진행)

## ❓ 프로젝트 목적
- 물류 관리 및 배송 시스템
- MSA 기반의 시스템을 설계하고 구현하면서 다양한 기술과 방법론을 적용함.
- 프로젝트를 통해 MSA의 복잡성을 이해하고, 실무에서 발생할 수 있는 문제를 간접적으로 경험하고 해결하고자 함.  

## 🗂️ 주요 서비스
- eureka-server
전체 어플리케이션 관리
- config-server
전체 어플리케이션 설정 파일 관리
- gateway-service
요청의 모든 인입 관리
- auth-service
인증 및 권한 확인 관리
- company-service
업체 관리
- hub-service
허브와 허브간 이동정보 관리
- order-service
주문 관리
- delivery-manager-service
배송과 배송 경로와 배송 담당자 관리
- product-service
상품 관리
- slack-service
슬랙 메시지 관리
AI 연동 관리
  
## 🧑🏻‍💻 팀 구성
<table>
<tbody>
<tr>
<td align="center">
<a href="https://github.com/k-jaehyun">
<img src="https://ca.slack-edge.com/T06B9PCLY1E-U07Q5EL6JPQ-f14a05f6d345-512" width="100px;" alt="프로필이미지"/>
<br />
<sub><b>[팀장] 김재현</b></sub>
<br />
</a>
<span>Order, Product, Slack</span>
</td>
<td align="center">
<a href="https://github.com/drinkgalaxy">
<img src="docs/images/hyunjin.jpg" width="100px;" alt="프로필이미지"/>
<br />
<sub><b>이현진</b></sub>
<br />
</a>
<span>Company, Hub, HubRoute, Ai</span>
</td>
<td align="center">
<a href="https://github.com/hiimsajo">
<img src="docs/images/seunga.jpg" width="100px;" alt="프로필이미지"/>
<br />
<sub><b>조승아</b></sub>
</a>
<br />
<span>Delivery, DeliveryRoute, DeliveryManager</span>
</td>
<td align="center">
<a href="https://github.com/Yuurim98">
<img src="docs/images/yurim.jpg" width="100px;" alt="프로필이미지"/>
<br />
<sub><b>최유림</b></span>
<br />
</a>
<span>Auth, 인증/인가, Swagger</span>
</td>
</tr>
</tbody>
</table>

## 📄 API docs
<img src="docs/images/auth, user API.png" alt="auth, user API"/>
<img src="docs/images/company API.png" alt="company API"/>
<img src="docs/images/deliveryManager API.png" alt="deliveryManager API"/>
<img src="docs/images/hub API.png" alt="hub API"/>
<img src="docs/images/order API.png" alt="order API"/>
<img src="docs/images/product API.png" alt="product API"/>
<img src="docs/images/slack API.png" alt="slack API"/>

## 🛠 개발 환경
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Google Gemini AI](https://img.shields.io/badge/Google%20Gemini%20AI-4285F4?style=for-the-badge&logo=google&logoColor=white)
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)

## 📃 인프라 설계서
![image](https://github.com/user-attachments/assets/776d0bfe-0a3f-44fe-96bd-58a476a28c87)


## 📑 ERD
![team4erd](https://github.com/user-attachments/assets/297b320f-a622-4329-8847-8ff088fe336e)

## 📁 프로젝트 파일 구조
- Microservices Architecture
- Layered Architecture + DDD
```
├─auth-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─auth_service
│  │  │                          │  AuthServiceApplication.class
│  │  │                          │
│  │  │                          ├─application
│  │  │                          │  ├─dto
│  │  │                          │  │      CustomUserDetails.class
│  │  │                          │  │      SignupResDto.class
│  │  │                          │  │      UserResDto.class
│  │  │                          │  │
│  │  │                          │  └─service
│  │  │                          │          AuthService.class
│  │  │                          │          CustomUserDetailsService.class
│  │  │                          │          UserService.class
│  │  │                          │
│  │  │                          ├─common
│  │  │                          │  │  ResponseDto.class
│  │  │                          │  │
│  │  │                          │  ├─entity
│  │  │                          │  │      BaseEntity.class
│  │  │                          │  │
│  │  │                          │  └─exception
│  │  │                          │          CustomApiException.class
│  │  │                          │          CustomExceptionHandler.class
│  │  │                          │
│  │  │                          ├─config
│  │  │                          │  │  AuditorAwareImpl.class
│  │  │                          │  │  SecurityConfig.class
│  │  │                          │  │
│  │  │                          │  └─jwt
│  │  │                          │          JwtAuthenticationFilter.class
│  │  │                          │          JwtUtil.class
│  │  │                          │          LoginFilter.class
│  │  │                          │
│  │  │                          ├─domain
│  │  │                          │  ├─model
│  │  │                          │  │      Role.class
│  │  │                          │  │      User$UserBuilder.class
│  │  │                          │  │      User.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          UserRepository.class
│  │  │                          │
│  │  │                          └─presentation
│  │  │                              ├─controller
│  │  │                              │      AuthController.class
│  │  │                              │      UserController.class
│  │  │                              │
│  │  │                              └─request
│  │  │                                      DeleteReqDto.class
│  │  │                                      PasswordUpdateReqDto.class
│  │  │                                      SigninReqDto.class
│  │  │                                      SignupReqDto.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │          │  previous-compilation-data.bin
│  │          │
│  │          └─compileTransaction
│  │              ├─backup-dir
│  │              └─stash-dir
│  │                      SecurityConfig.class.uniqueId0
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─auth_service
│      │  │                  │  AuthServiceApplication.java
│      │  │                  │
│      │  │                  ├─application
│      │  │                  │  ├─dto
│      │  │                  │  │      CustomUserDetails.java
│      │  │                  │  │
│      │  │                  │  └─service
│      │  │                  │          AuthService.java
│      │  │                  │          CustomUserDetailsService.java
│      │  │                  │          UserService.java
│      │  │                  │
│      │  │                  ├─domain
│      │  │                  │  ├─model
│      │  │                  │  │      Role.java
│      │  │                  │  │      User.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          UserRepository.java
│      │  │                  │
│      │  │                  ├─infrastructure
│      │  │                  │  └─config
│      │  │                  │      │  AuditorAwareImpl.java
│      │  │                  │      │  SecurityConfig.java
│      │  │                  │      │  SwaggerConfig.java
│      │  │                  │      │
│      │  │                  │      └─jwt
│      │  │                  │          │  JwtUtil.java
│      │  │                  │          │
│      │  │                  │          └─filter
│      │  │                  │                  JwtAuthorizationFilter.java
│      │  │                  │                  LoginFilter.java
│      │  │                  │
│      │  │                  └─presentation
│      │  │                      ├─controller
│      │  │                      │      AuthController.java
│      │  │                      │      UserController.java
│      │  │                      │
│      │  │                      ├─global
│      │  │                      │  │  ResponseDto.java
│      │  │                      │  │
│      │  │                      │  ├─entity
│      │  │                      │  │      BaseEntity.java
│      │  │                      │  │
│      │  │                      │  ├─exception
│      │  │                      │  │      CustomApiException.java
│      │  │                      │  │
│      │  │                      │  └─hadler
│      │  │                      │          CustomExceptionHandler.java
│      │  │                      │
│      │  │                      ├─request
│      │  │                      │      DeleteReqDto.java
│      │  │                      │      PasswordUpdateReqDto.java
│      │  │                      │      SigninReqDto.java
│      │  │                      │      SignupReqDto.java
│      │  │                      │
│      │  │                      └─response
│      │  │                              SignupResDto.java
│      │  │                              UserResDto.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─auth_service
│                                  AuthServiceApplicationTests.java
│
├─company-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─8.2
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │      md5-checksums.bin
│  │  │  │      sha1-checksums.bin
│  │  │  │
│  │  │  ├─dependencies-accessors
│  │  │  │      dependencies-accessors.lock
│  │  │  │      gc.properties
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─company_service
│  │  │                          │  CompanyServiceApplication.class
│  │  │                          │
│  │  │                          ├─application
│  │  │                          │  ├─dto
│  │  │                          │  │      HubResponseDto.class
│  │  │                          │  │      HubType.class
│  │  │                          │  │      Role.class
│  │  │                          │  │      UserResDto.class
│  │  │                          │  │
│  │  │                          │  └─service
│  │  │                          │          CompanyService.class
│  │  │                          │          HubService.class
│  │  │                          │          HubServiceImpl.class
│  │  │                          │          UserService.class
│  │  │                          │          UserServiceImpl.class
│  │  │                          │
│  │  │                          ├─domain
│  │  │                          │  ├─model
│  │  │                          │  │      Company$CompanyBuilder.class
│  │  │                          │  │      Company.class
│  │  │                          │  │      CompanyType.class
│  │  │                          │  │      QCompany.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          CompanyRepository.class
│  │  │                          │
│  │  │                          ├─infrastructure
│  │  │                          │  ├─client
│  │  │                          │  │      HubClient.class
│  │  │                          │  │      UserClient.class
│  │  │                          │  │
│  │  │                          │  └─config
│  │  │                          │          CacheConfig.class
│  │  │                          │          RedisConfig.class
│  │  │                          │
│  │  │                          └─presentation
│  │  │                              ├─controller
│  │  │                              │      CompanyController.class
│  │  │                              │
│  │  │                              ├─global
│  │  │                              │  │  ResponseDto.class
│  │  │                              │  │
│  │  │                              │  ├─ex
│  │  │                              │  │      CustomApiException.class
│  │  │                              │  │      FeignErrorDecoder.class
│  │  │                              │  │
│  │  │                              │  └─handler
│  │  │                              │          CustomExceptionHandler.class
│  │  │                              │
│  │  │                              ├─request
│  │  │                              │      CompanyCreateRequest.class
│  │  │                              │      CompanyModifyRequest.class
│  │  │                              │
│  │  │                              └─response
│  │  │                                      CompanyResponse.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      │          └─com
│  │  │      │              └─logistics
│  │  │      │                  └─platform
│  │  │      │                      └─company_service
│  │  │      │                          └─domain
│  │  │      │                              └─model
│  │  │      │                                      QCompany.java
│  │  │      │
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │          │  previous-compilation-data.bin
│  │          │
│  │          └─compileTransaction
│  │              ├─backup-dir
│  │              └─stash-dir
│  │                      CompanyController.class.uniqueId1
│  │                      CompanyService.class.uniqueId3
│  │                      HubServiceImpl.class.uniqueId0
│  │                      UserServiceImpl.class.uniqueId2
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─company_service
│      │  │                  │  CompanyServiceApplication.java
│      │  │                  │
│      │  │                  ├─application
│      │  │                  │  ├─dto
│      │  │                  │  │      HubResponseDto.java
│      │  │                  │  │      HubType.java
│      │  │                  │  │      Role.java
│      │  │                  │  │      UserResDto.java
│      │  │                  │  │
│      │  │                  │  └─service
│      │  │                  │          CompanyService.java
│      │  │                  │          HubService.java
│      │  │                  │          HubServiceImpl.java
│      │  │                  │          UserService.java
│      │  │                  │          UserServiceImpl.java
│      │  │                  │
│      │  │                  ├─domain
│      │  │                  │  ├─model
│      │  │                  │  │      Company.java
│      │  │                  │  │      CompanyType.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          CompanyRepository.java
│      │  │                  │
│      │  │                  ├─infrastructure
│      │  │                  │  ├─client
│      │  │                  │  │      HubClient.java
│      │  │                  │  │      UserClient.java
│      │  │                  │  │
│      │  │                  │  └─config
│      │  │                  │          CacheConfig.java
│      │  │                  │          RedisConfig.java
│      │  │                  │          SwaggerConfig.java
│      │  │                  │
│      │  │                  └─presentation
│      │  │                      ├─controller
│      │  │                      │      CompanyController.java
│      │  │                      │
│      │  │                      ├─global
│      │  │                      │  │  ResponseDto.java
│      │  │                      │  │
│      │  │                      │  ├─ex
│      │  │                      │  │      CustomApiException.java
│      │  │                      │  │      FeignErrorDecoder.java
│      │  │                      │  │
│      │  │                      │  └─handler
│      │  │                      │          CustomExceptionHandler.java
│      │  │                      │
│      │  │                      ├─request
│      │  │                      │      CompanyCreateRequest.java
│      │  │                      │      CompanyModifyRequest.java
│      │  │                      │
│      │  │                      └─response
│      │  │                              CompanyResponse.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─company_service
│                                  CompanyServiceApplicationTests.java
│
├─config-server
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─config_service
│  │  │                              ConfigServiceApplication.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │      │  application.yml
│  │  │      │
│  │  │      └─config-repo
│  │  │              auth-service.yml
│  │  │              company-service.yml
│  │  │              delivery-manager-service.yml
│  │  │              delivery-service.yml
│  │  │              gateway-service.yml
│  │  │              hub-service.yml
│  │  │              order-service.yml
│  │  │              product-service.yml
│  │  │              slack-service.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │          │  previous-compilation-data.bin
│  │          │
│  │          └─compileTransaction
│  │              ├─backup-dir
│  │              └─stash-dir
│  │                      ConfigServiceApplication.class.uniqueId0
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─config_service
│      │  │                      ConfigServiceApplication.java
│      │  │
│      │  └─resources
│      │      │  application.yml
│      │      │
│      │      └─config-repo
│      │              auth-service.yml
│      │              company-service.yml
│      │              delivery-manager-service.yml
│      │              delivery-service.yml
│      │              gateway-service.yml
│      │              hub-service.yml
│      │              order-service.yml
│      │              product-service.yml
│      │              slack-service.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─config_service
│                                  ConfigServiceApplicationTests.java
│
├─delivery-manager-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.8
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │      md5-checksums.bin
│  │  │  │      sha1-checksums.bin
│  │  │  │
│  │  │  ├─dependencies-accessors
│  │  │  │      gc.properties
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─deliverymanagerservice
│  │  │                          │  DeliveryManagerServiceApplication.class
│  │  │                          │
│  │  │                          ├─application
│  │  │                          │  └─service
│  │  │                          │          DeliveryManagerService.class
│  │  │                          │
│  │  │                          ├─domain
│  │  │                          │  ├─model
│  │  │                          │  │      AuditingFields.class
│  │  │                          │  │      DeliveryManager$DeliveryManagerBuilder.class
│  │  │                          │  │      DeliveryManager.class
│  │  │                          │  │      DeliveryType.class
│  │  │                          │  │      QAuditingFields.class
│  │  │                          │  │      QDeliveryManager.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          DeliveryManagerRepository.class
│  │  │                          │
│  │  │                          ├─infrastructure
│  │  │                          │  ├─configuration
│  │  │                          │  │      JpaConfig.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          DeliveryManagerRepositoryCustom.class
│  │  │                          │          DeliveryManagerRepositoryCustomImpl.class
│  │  │                          │
│  │  │                          └─presentation
│  │  │                              ├─controller
│  │  │                              │      DeliveryManagerController.class
│  │  │                              │
│  │  │                              ├─global
│  │  │                              │  │  ResponseDto.class
│  │  │                              │  │
│  │  │                              │  ├─exception
│  │  │                              │  │      CustomApiException.class
│  │  │                              │  │
│  │  │                              │  └─handler
│  │  │                              │          CustomExceptionHandler.class
│  │  │                              │
│  │  │                              ├─request
│  │  │                              │      DeliveryManagerRequestDto.class
│  │  │                              │      DeliveryManagerUpdateRequestDto.class
│  │  │                              │
│  │  │                              └─response
│  │  │                                      DeliveryManagerResponseDto.class
│  │  │                                      QDeliveryManagerResponseDto.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      │          └─com
│  │  │      │              └─logistics
│  │  │      │                  └─platform
│  │  │      │                      └─deliverymanagerservice
│  │  │      │                          ├─domain
│  │  │      │                          │  └─model
│  │  │      │                          │          QAuditingFields.java
│  │  │      │                          │          QDeliveryManager.java
│  │  │      │                          │
│  │  │      │                          └─presentation
│  │  │      │                              └─response
│  │  │      │                                      QDeliveryManagerResponseDto.java
│  │  │      │
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │              previous-compilation-data.bin
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─deliverymanagerservice
│      │  │                  │  DeliveryManagerServiceApplication.java
│      │  │                  │
│      │  │                  ├─application
│      │  │                  │  ├─dto
│      │  │                  │  │      UserResDto.java
│      │  │                  │  │
│      │  │                  │  └─service
│      │  │                  │          DeliveryManagerService.java
│      │  │                  │          ManagerOrderIndexService.java
│      │  │                  │          UserSerivce.java
│      │  │                  │          UserServiceImpl.java
│      │  │                  │
│      │  │                  ├─domain
│      │  │                  │  ├─model
│      │  │                  │  │      DeliveryManager.java
│      │  │                  │  │      DeliveryOrderIndex.java
│      │  │                  │  │      DeliveryType.java
│      │  │                  │  │      Role.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          DeliveryManagerRepository.java
│      │  │                  │          DeliveryOrderIndexRepository.java
│      │  │                  │
│      │  │                  ├─infrastructure
│      │  │                  │  ├─client
│      │  │                  │  │      HubClient.java
│      │  │                  │  │      UserClient.java
│      │  │                  │  │
│      │  │                  │  ├─configuration
│      │  │                  │  │      JpaConfig.java
│      │  │                  │  │      SwaggerConfig.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          DeliveryManagerRepositoryCustom.java
│      │  │                  │          DeliveryManagerRepositoryCustomImpl.java
│      │  │                  │
│      │  │                  └─presentation
│      │  │                      ├─controller
│      │  │                      │      DeliveryManagerController.java
│      │  │                      │
│      │  │                      ├─global
│      │  │                      │  │  ResponseDto.java
│      │  │                      │  │
│      │  │                      │  ├─exception
│      │  │                      │  │      CustomApiException.java
│      │  │                      │  │
│      │  │                      │  └─handler
│      │  │                      │          CustomExceptionHandler.java
│      │  │                      │
│      │  │                      ├─request
│      │  │                      │      DeliveryManagerRequestDto.java
│      │  │                      │      DeliveryManagerUpdateRequestDto.java
│      │  │                      │
│      │  │                      └─response
│      │  │                              DeliveryManagerResponseDto.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─deliverymanagerservice
│                                  DeliveryManagerServiceApplicationTests.java
│
├─delivery-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─delivery_service
│      │  │                  │  DeliveryServiceApplication.java
│      │  │                  │
│      │  │                  ├─delivery
│      │  │                  │  ├─application
│      │  │                  │  │  ├─dto
│      │  │                  │  │  │      HubRouteCreateRequest.java
│      │  │                  │  │  │      HubRouteResponseDto.java
│      │  │                  │  │  │      SlackRequestDto.java
│      │  │                  │  │  │
│      │  │                  │  │  └─service
│      │  │                  │  │          DeliveryService.java
│      │  │                  │  │          SlackService.java
│      │  │                  │  │
│      │  │                  │  ├─domain
│      │  │                  │  │  ├─model
│      │  │                  │  │  │      Delivery.java
│      │  │                  │  │  │      DeliveryStatus.java
│      │  │                  │  │  │
│      │  │                  │  │  └─repository
│      │  │                  │  │          DeliveryRepository.java
│      │  │                  │  │
│      │  │                  │  ├─infrastructure
│      │  │                  │  │  ├─client
│      │  │                  │  │  │      HubClient.java
│      │  │                  │  │  │      SlackClient.java
│      │  │                  │  │  │
│      │  │                  │  │  ├─configuration
│      │  │                  │  │  │      JpaConfig.java
│      │  │                  │  │  │
│      │  │                  │  │  └─repository
│      │  │                  │  │          DeliveryRepositoryCustom.java
│      │  │                  │  │          DeliveryRepositoryCustomImpl.java
│      │  │                  │  │
│      │  │                  │  └─presentation
│      │  │                  │      ├─controller
│      │  │                  │      │      DeliveryController.java
│      │  │                  │      │
│      │  │                  │      ├─request
│      │  │                  │      │      DeliveryRequestDto.java
│      │  │                  │      │      DeliveryUpdateRequestDto.java
│      │  │                  │      │
│      │  │                  │      └─response
│      │  │                  │              DeliveryResponseDto.java
│      │  │                  │
│      │  │                  ├─deliveryRoute
│      │  │                  │  ├─application
│      │  │                  │  │  └─service
│      │  │                  │  │      │  DeliveryRouteService.java
│      │  │                  │  │      │
│      │  │                  │  │      └─dto
│      │  │                  │  │              DeliveryManagerResponseDto.java
│      │  │                  │  │
│      │  │                  │  ├─domain
│      │  │                  │  │  ├─model
│      │  │                  │  │  │      DeliveryRoute.java
│      │  │                  │  │  │      DeliveryRouteStatus.java
│      │  │                  │  │  │
│      │  │                  │  │  └─repository
│      │  │                  │  │          DeliveryRouteRepository.java
│      │  │                  │  │
│      │  │                  │  ├─infrastructure
│      │  │                  │  │  ├─client
│      │  │                  │  │  │      DeliveryManagerClient.java
│      │  │                  │  │  │
│      │  │                  │  │  ├─configuration
│      │  │                  │  │  │      JpaConfig.java
│      │  │                  │  │  │
│      │  │                  │  │  └─repository
│      │  │                  │  │          DeliveryRouteRepositoryCustom.java
│      │  │                  │  │          DeliveryRouteRepositoryCustomImpl.java
│      │  │                  │  │
│      │  │                  │  └─presentation
│      │  │                  │      ├─controller
│      │  │                  │      │      DeliveryRouteController.java
│      │  │                  │      │
│      │  │                  │      ├─request
│      │  │                  │      │      DeliveryRouteRequestDto.java
│      │  │                  │      │
│      │  │                  │      └─response
│      │  │                  │              DeliveryRouteResponseDto.java
│      │  │                  │
│      │  │                  └─global
│      │  │                      └─global
│      │  │                          │  ResponseDto.java
│      │  │                          │
│      │  │                          ├─exception
│      │  │                          │      CustomApiException.java
│      │  │                          │
│      │  │                          └─handler
│      │  │                                  CustomExceptionHandler.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─delivery_service
│                                  DeliveryServiceApplicationTests.java
│
├─docs
│  └─images
│          auth, user API.png
│          company API.png
│          deliveryManager API.png
│          hub API.png
│          hyunjin.jpg
│          order API.png
│          product API.png
│          seunga.jpg
│          slack API.png
│          yurim.jpg
│
├─eureka-server
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─eureka_server
│  │  │                              EurekaServerApplication.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │              previous-compilation-data.bin
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─eureka_server
│      │  │                      EurekaServerApplication.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─eureka_server
│                                  EurekaServerApplicationTests.java
│
├─gateway-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │      md5-checksums.bin
│  │  │  │      sha1-checksums.bin
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─gateway_service
│  │  │                          │  GatewayServiceApplication.class
│  │  │                          │
│  │  │                          ├─filter
│  │  │                          │      AuthPreFilter.class
│  │  │                          │
│  │  │                          └─jwt
│  │  │                                  JwtUtil.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │              previous-compilation-data.bin
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─gateway_service
│      │  │                  │  GatewayServiceApplication.java
│      │  │                  │
│      │  │                  ├─filter
│      │  │                  │      AuthPreFilter.java
│      │  │                  │
│      │  │                  └─jwt
│      │  │                          JwtUtil.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─gateway_service
│                                  GatewayServiceApplicationTests.java
│
├─hub-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─8.2
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │      md5-checksums.bin
│  │  │  │      sha1-checksums.bin
│  │  │  │
│  │  │  ├─dependencies-accessors
│  │  │  │      dependencies-accessors.lock
│  │  │  │      gc.properties
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─hub_service
│  │  │                          │  HubServiceApplication.class
│  │  │                          │
│  │  │                          ├─application
│  │  │                          │  └─service
│  │  │                          │      │  HubRouteService.class
│  │  │                          │      │  HubService.class
│  │  │                          │      │
│  │  │                          │      ├─google
│  │  │                          │      │      GeocodingService.class
│  │  │                          │      │
│  │  │                          │      └─kakao
│  │  │                          │              KakaoDirectionParser$DirectionInfo.class
│  │  │                          │              KakaoDirectionParser.class
│  │  │                          │              KakaoMobilityService.class
│  │  │                          │
│  │  │                          ├─domain
│  │  │                          │  ├─model
│  │  │                          │  │      Hub$HubBuilder.class
│  │  │                          │  │      Hub.class
│  │  │                          │  │      HubRoute$HubRouteBuilder.class
│  │  │                          │  │      HubRoute.class
│  │  │                          │  │      HubType.class
│  │  │                          │  │      QHub.class
│  │  │                          │  │      QHubRoute.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          HubRepository.class
│  │  │                          │          HubRouteRepository.class
│  │  │                          │
│  │  │                          ├─infrastructure
│  │  │                          │  │  AppConfig.class
│  │  │                          │  │
│  │  │                          │  └─config
│  │  │                          │          CacheConfig.class
│  │  │                          │          RedisConfig.class
│  │  │                          │
│  │  │                          └─presentation
│  │  │                              ├─controller
│  │  │                              │      HubController.class
│  │  │                              │      HubRouteController.class
│  │  │                              │
│  │  │                              ├─global
│  │  │                              │  │  ResponseDto.class
│  │  │                              │  │
│  │  │                              │  ├─ex
│  │  │                              │  │      CustomApiException.class
│  │  │                              │  │
│  │  │                              │  └─handler
│  │  │                              │          CustomExceptionHandler.class
│  │  │                              │
│  │  │                              ├─request
│  │  │                              │      HubCreateRequest.class
│  │  │                              │      HubModifyRequest.class
│  │  │                              │      HubRouteCreateRequest.class
│  │  │                              │
│  │  │                              ├─response
│  │  │                              │      AddressResponse.class
│  │  │                              │      HubResponse.class
│  │  │                              │      HubRouteCreateResponse.class
│  │  │                              │      HubRouteResponse.class
│  │  │                              │
│  │  │                              └─util
│  │  │                                      GeoUtils.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      │          └─com
│  │  │      │              └─logistics
│  │  │      │                  └─platform
│  │  │      │                      └─hub_service
│  │  │      │                          └─domain
│  │  │      │                              └─model
│  │  │      │                                      QHub.java
│  │  │      │                                      QHubRoute.java
│  │  │      │
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │          │  previous-compilation-data.bin
│  │          │
│  │          └─compileTransaction
│  │              ├─backup-dir
│  │              └─stash-dir
│  │                      HubController.class.uniqueId0
│  │                      HubService.class.uniqueId1
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─hub_service
│      │  │                  │  HubServiceApplication.java
│      │  │                  │
│      │  │                  ├─application
│      │  │                  │  └─service
│      │  │                  │      │  HubRouteService.java
│      │  │                  │      │  HubService.java
│      │  │                  │      │
│      │  │                  │      ├─google
│      │  │                  │      │      GeocodingService.java
│      │  │                  │      │
│      │  │                  │      └─kakao
│      │  │                  │              KakaoDirectionParser.java
│      │  │                  │              KakaoMobilityService.java
│      │  │                  │
│      │  │                  ├─domain
│      │  │                  │  ├─model
│      │  │                  │  │      Hub.java
│      │  │                  │  │      HubRoute.java
│      │  │                  │  │      HubType.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          HubRepository.java
│      │  │                  │          HubRouteRepository.java
│      │  │                  │
│      │  │                  ├─infrastructure
│      │  │                  │  │  AppConfig.java
│      │  │                  │  │
│      │  │                  │  └─config
│      │  │                  │          CacheConfig.java
│      │  │                  │          RedisConfig.java
│      │  │                  │          SwaggerConfig.java
│      │  │                  │
│      │  │                  └─presentation
│      │  │                      ├─controller
│      │  │                      │      HubController.java
│      │  │                      │      HubRouteController.java
│      │  │                      │
│      │  │                      ├─global
│      │  │                      │  │  ResponseDto.java
│      │  │                      │  │
│      │  │                      │  ├─ex
│      │  │                      │  │      CustomApiException.java
│      │  │                      │  │
│      │  │                      │  └─handler
│      │  │                      │          CustomExceptionHandler.java
│      │  │                      │
│      │  │                      ├─request
│      │  │                      │      HubCreateRequest.java
│      │  │                      │      HubModifyRequest.java
│      │  │                      │      HubRouteCreateRequest.java
│      │  │                      │
│      │  │                      ├─response
│      │  │                      │      AddressResponse.java
│      │  │                      │      HubResponse.java
│      │  │                      │      HubRouteCreateResponse.java
│      │  │                      │      HubRouteResponse.java
│      │  │                      │
│      │  │                      └─util
│      │  │                              GeoUtils.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─hub_service
│                                  HubServiceApplicationTests.java
│
├─order-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │      md5-checksums.bin
│  │  │  │      sha1-checksums.bin
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─order_service
│  │  │                          │  OrderServiceApplication.class
│  │  │                          │
│  │  │                          ├─application
│  │  │                          │  ├─dto
│  │  │                          │  │      ProductResponseDto.class
│  │  │                          │  │
│  │  │                          │  └─service
│  │  │                          │          OrderService.class
│  │  │                          │          ProductService.class
│  │  │                          │          ProductServiceImpl.class
│  │  │                          │
│  │  │                          ├─domain
│  │  │                          │  ├─model
│  │  │                          │  │      Order$OrderBuilder.class
│  │  │                          │  │      Order.class
│  │  │                          │  │      QOrder.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          OrderRepository.class
│  │  │                          │
│  │  │                          ├─infrastructure
│  │  │                          │  ├─circuitbreaker
│  │  │                          │  │      CircuitBreakerListener.class
│  │  │                          │  │
│  │  │                          │  ├─client
│  │  │                          │  │      ProductClient.class
│  │  │                          │  │
│  │  │                          │  ├─configuration
│  │  │                          │  │      CacheConfig.class
│  │  │                          │  │      JpaConfig.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          OrderRepositoryCustom.class
│  │  │                          │          OrderRepositoryImpl.class
│  │  │                          │
│  │  │                          └─presentation
│  │  │                              ├─controller
│  │  │                              │      OrderController.class
│  │  │                              │
│  │  │                              ├─global
│  │  │                              │  │  ResponseDto.class
│  │  │                              │  │
│  │  │                              │  ├─exception
│  │  │                              │  │      CustomApiException.class
│  │  │                              │  │
│  │  │                              │  └─hadler
│  │  │                              │          CustomExceptionHandler.class
│  │  │                              │
│  │  │                              ├─request
│  │  │                              │      OrderRequestDto.class
│  │  │                              │
│  │  │                              └─response
│  │  │                                      OrderResponseDto.class
│  │  │                                      QOrderResponseDto.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      │          └─com
│  │  │      │              └─logistics
│  │  │      │                  └─platform
│  │  │      │                      └─order_service
│  │  │      │                          ├─domain
│  │  │      │                          │  └─model
│  │  │      │                          │          QOrder.java
│  │  │      │                          │
│  │  │      │                          └─presentation
│  │  │      │                              └─response
│  │  │      │                                      QOrderResponseDto.java
│  │  │      │
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │              previous-compilation-data.bin
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─order_service
│      │  │                  │  OrderServiceApplication.java
│      │  │                  │
│      │  │                  ├─application
│      │  │                  │  ├─dto
│      │  │                  │  │      ProductResponseDto.java
│      │  │                  │  │      Role.java
│      │  │                  │  │      UserDto.java
│      │  │                  │  │
│      │  │                  │  └─service
│      │  │                  │      ├─company
│      │  │                  │      │      CompanyService.java
│      │  │                  │      │      CompanyServiceImpl.java
│      │  │                  │      │
│      │  │                  │      ├─delivery
│      │  │                  │      │      DeliveryService.java
│      │  │                  │      │      DeliveryServiceImpl.java
│      │  │                  │      │
│      │  │                  │      ├─hub
│      │  │                  │      │      HubService.java
│      │  │                  │      │      HubServiceImpl.java
│      │  │                  │      │
│      │  │                  │      ├─order
│      │  │                  │      │      OrderService.java
│      │  │                  │      │
│      │  │                  │      ├─product
│      │  │                  │      │      ProductService.java
│      │  │                  │      │      ProductServiceImpl.java
│      │  │                  │      │
│      │  │                  │      └─user
│      │  │                  │              UserSerivce.java
│      │  │                  │              UserServiceImpl.java
│      │  │                  │
│      │  │                  ├─domain
│      │  │                  │  ├─model
│      │  │                  │  │      Order.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          OrderRepository.java
│      │  │                  │
│      │  │                  ├─infrastructure
│      │  │                  │  ├─circuitbreaker
│      │  │                  │  │      CircuitBreakerListener.java
│      │  │                  │  │
│      │  │                  │  ├─client
│      │  │                  │  │      CompanyClient.java
│      │  │                  │  │      DeliveryClient.java
│      │  │                  │  │      ProductClient.java
│      │  │                  │  │      UserClient.java
│      │  │                  │  │
│      │  │                  │  ├─configuration
│      │  │                  │  │      CacheConfig.java
│      │  │                  │  │      JpaConfig.java
│      │  │                  │  │      SwaggerConfig.java
│      │  │                  │  │
│      │  │                  │  ├─repository
│      │  │                  │  │      OrderRepositoryCustom.java
│      │  │                  │  │      OrderRepositoryImpl.java
│      │  │                  │  │
│      │  │                  │  └─request
│      │  │                  │          DeliveryRequestDto.java
│      │  │                  │
│      │  │                  └─presentation
│      │  │                      ├─controller
│      │  │                      │      OrderController.java
│      │  │                      │
│      │  │                      ├─global
│      │  │                      │  │  ResponseDto.java
│      │  │                      │  │
│      │  │                      │  ├─exception
│      │  │                      │  │      CustomApiException.java
│      │  │                      │  │
│      │  │                      │  └─hadler
│      │  │                      │          CustomExceptionHandler.java
│      │  │                      │
│      │  │                      ├─request
│      │  │                      │      OrderRequestDto.java
│      │  │                      │
│      │  │                      └─response
│      │  │                              OrderResponseDto.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─order_service
│                                  OrderServiceApplicationTests.java
│
├─product-service
│  │  .gitattributes
│  │  .gitignore
│  │  build.gradle
│  │  gradlew
│  │  gradlew.bat
│  │  settings.gradle
│  │
│  ├─.gradle
│  │  │  file-system.probe
│  │  │
│  │  ├─8.11.1
│  │  │  │  gc.properties
│  │  │  │
│  │  │  ├─checksums
│  │  │  │      checksums.lock
│  │  │  │      md5-checksums.bin
│  │  │  │      sha1-checksums.bin
│  │  │  │
│  │  │  ├─executionHistory
│  │  │  │      executionHistory.bin
│  │  │  │      executionHistory.lock
│  │  │  │
│  │  │  ├─expanded
│  │  │  ├─fileChanges
│  │  │  │      last-build.bin
│  │  │  │
│  │  │  ├─fileHashes
│  │  │  │      fileHashes.bin
│  │  │  │      fileHashes.lock
│  │  │  │      resourceHashesCache.bin
│  │  │  │
│  │  │  └─vcsMetadata
│  │  ├─buildOutputCleanup
│  │  │      buildOutputCleanup.lock
│  │  │      cache.properties
│  │  │      outputFiles.bin
│  │  │
│  │  └─vcs-1
│  │          gc.properties
│  │
│  ├─build
│  │  ├─classes
│  │  │  └─java
│  │  │      └─main
│  │  │          └─com
│  │  │              └─logistics
│  │  │                  └─platform
│  │  │                      └─product_service
│  │  │                          │  ProductServiceApplication.class
│  │  │                          │
│  │  │                          ├─application
│  │  │                          │  └─service
│  │  │                          │          ProductService.class
│  │  │                          │
│  │  │                          ├─domain
│  │  │                          │  ├─model
│  │  │                          │  │      Product$ProductBuilder.class
│  │  │                          │  │      Product.class
│  │  │                          │  │      QProduct.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          ProductRepository.class
│  │  │                          │
│  │  │                          ├─infrastructure
│  │  │                          │  ├─configuration
│  │  │                          │  │      CacheConfig.class
│  │  │                          │  │      JpaConfig.class
│  │  │                          │  │
│  │  │                          │  └─repository
│  │  │                          │          ProductRepositoryCustom.class
│  │  │                          │          ProductRepositoryCustomImpl.class
│  │  │                          │
│  │  │                          └─presentation
│  │  │                              ├─controller
│  │  │                              │      ProductController.class
│  │  │                              │
│  │  │                              ├─global
│  │  │                              │  │  ResponseDto.class
│  │  │                              │  │
│  │  │                              │  ├─exception
│  │  │                              │  │      CustomApiException.class
│  │  │                              │  │
│  │  │                              │  └─hadler
│  │  │                              │          CustomExceptionHandler.class
│  │  │                              │
│  │  │                              ├─request
│  │  │                              │      ProductRequestDto.class
│  │  │                              │
│  │  │                              └─response
│  │  │                                      ProductResponseDto.class
│  │  │                                      QProductResponseDto.class
│  │  │
│  │  ├─generated
│  │  │  └─sources
│  │  │      ├─annotationProcessor
│  │  │      │  └─java
│  │  │      │      └─main
│  │  │      │          └─com
│  │  │      │              └─logistics
│  │  │      │                  └─platform
│  │  │      │                      └─product_service
│  │  │      │                          ├─domain
│  │  │      │                          │  └─model
│  │  │      │                          │          QProduct.java
│  │  │      │                          │
│  │  │      │                          └─presentation
│  │  │      │                              └─response
│  │  │      │                                      QProductResponseDto.java
│  │  │      │
│  │  │      └─headers
│  │  │          └─java
│  │  │              └─main
│  │  ├─reports
│  │  │  └─problems
│  │  │          problems-report.html
│  │  │
│  │  ├─resources
│  │  │  └─main
│  │  │          application.yml
│  │  │
│  │  └─tmp
│  │      └─compileJava
│  │              previous-compilation-data.bin
│  │
│  ├─gradle
│  │  └─wrapper
│  │          gradle-wrapper.jar
│  │          gradle-wrapper.properties
│  │
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─logistics
│      │  │          └─platform
│      │  │              └─product_service
│      │  │                  │  ProductServiceApplication.java
│      │  │                  │
│      │  │                  ├─application
│      │  │                  │  ├─dto
│      │  │                  │  │      CompanyResponse.java
│      │  │                  │  │      HubResponseDto.java
│      │  │                  │  │      UserResDto.java
│      │  │                  │  │
│      │  │                  │  └─service
│      │  │                  │      │  ProductService.java
│      │  │                  │      │
│      │  │                  │      ├─auth
│      │  │                  │      │      AuthService.java
│      │  │                  │      │      AuthServiceImpl.java
│      │  │                  │      │
│      │  │                  │      ├─company
│      │  │                  │      │      CompanyService.java
│      │  │                  │      │      CompanyServiceImpl.java
│      │  │                  │      │
│      │  │                  │      └─hub
│      │  │                  │              HubServiceImpl.java
│      │  │                  │              HunService.java
│      │  │                  │
│      │  │                  ├─domain
│      │  │                  │  ├─model
│      │  │                  │  │      CompanyType.java
│      │  │                  │  │      HubType.java
│      │  │                  │  │      Product.java
│      │  │                  │  │      Role.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          ProductRepository.java
│      │  │                  │
│      │  │                  ├─infrastructure
│      │  │                  │  ├─client
│      │  │                  │  │      AuthClient.java
│      │  │                  │  │      CompanyClient.java
│      │  │                  │  │      HubClient.java
│      │  │                  │  │
│      │  │                  │  ├─configuration
│      │  │                  │  │      CacheConfig.java
│      │  │                  │  │      JpaConfig.java
│      │  │                  │  │      SwaggerConfig.java
│      │  │                  │  │
│      │  │                  │  └─repository
│      │  │                  │          ProductRepositoryCustom.java
│      │  │                  │          ProductRepositoryCustomImpl.java
│      │  │                  │
│      │  │                  └─presentation
│      │  │                      ├─controller
│      │  │                      │      ProductController.java
│      │  │                      │
│      │  │                      ├─global
│      │  │                      │  │  ResponseDto.java
│      │  │                      │  │
│      │  │                      │  ├─exception
│      │  │                      │  │      CustomApiException.java
│      │  │                      │  │
│      │  │                      │  └─hadler
│      │  │                      │          CustomExceptionHandler.java
│      │  │                      │
│      │  │                      ├─request
│      │  │                      │      ProductRequestDto.java
│      │  │                      │
│      │  │                      └─response
│      │  │                              ProductResponseDto.java
│      │  │
│      │  └─resources
│      │          application.yml
│      │
│      └─test
│          └─java
│              └─com
│                  └─logistics
│                      └─platform
│                          └─product_service
│                                  ProductServiceApplicationTests.java
│
└─slack-service
    │  .gitattributes
    │  .gitignore
    │  build.gradle
    │  gradlew
    │  gradlew.bat
    │  settings.gradle
    │
    ├─.gradle
    │  │  file-system.probe
    │  │
    │  ├─8.11.1
    │  │  │  gc.properties
    │  │  │
    │  │  ├─checksums
    │  │  │      checksums.lock
    │  │  │      md5-checksums.bin
    │  │  │      sha1-checksums.bin
    │  │  │
    │  │  ├─executionHistory
    │  │  │      executionHistory.bin
    │  │  │      executionHistory.lock
    │  │  │
    │  │  ├─expanded
    │  │  ├─fileChanges
    │  │  │      last-build.bin
    │  │  │
    │  │  ├─fileHashes
    │  │  │      fileHashes.bin
    │  │  │      fileHashes.lock
    │  │  │      resourceHashesCache.bin
    │  │  │
    │  │  └─vcsMetadata
    │  ├─buildOutputCleanup
    │  │      buildOutputCleanup.lock
    │  │      cache.properties
    │  │      outputFiles.bin
    │  │
    │  └─vcs-1
    │          gc.properties
    │
    ├─build
    │  ├─classes
    │  │  └─java
    │  │      └─main
    │  │          └─com
    │  │              └─logistics
    │  │                  └─platform
    │  │                      └─slack_service
    │  │                          │  SlackServiceApplication.class
    │  │                          │
    │  │                          ├─application
    │  │                          │  └─service
    │  │                          │      ├─auth
    │  │                          │      │      AuthService.class
    │  │                          │      │      AuthServiceImpl.class
    │  │                          │      │
    │  │                          │      ├─message
    │  │                          │      │      MessageService.class
    │  │                          │      │      MessageServiceImpl.class
    │  │                          │      │
    │  │                          │      └─slack
    │  │                          │              SlackService.class
    │  │                          │
    │  │                          ├─common
    │  │                          │  │  ResponseDto.class
    │  │                          │  │
    │  │                          │  └─exception
    │  │                          │          CustomApiException.class
    │  │                          │          CustomExceptionHandler.class
    │  │                          │
    │  │                          ├─domain
    │  │                          │  ├─model
    │  │                          │  │      QSlack.class
    │  │                          │  │      Slack$SlackBuilder.class
    │  │                          │  │      Slack.class
    │  │                          │  │
    │  │                          │  └─repository
    │  │                          │          SlackRepository.class
    │  │                          │
    │  │                          ├─infrastructure
    │  │                          │  ├─client
    │  │                          │  │      AuthClient.class
    │  │                          │  │
    │  │                          │  ├─configuration
    │  │                          │  │      CacheConfig.class
    │  │                          │  │      JpaConfig.class
    │  │                          │  │      RestTemplateConfig.class
    │  │                          │  │
    │  │                          │  └─repository
    │  │                          │          SlackRepositoryCustom.class
    │  │                          │          SlackRepositoryCustomImpl.class
    │  │                          │
    │  │                          └─presentation
    │  │                              ├─controller
    │  │                              │      SalckController.class
    │  │                              │
    │  │                              ├─request
    │  │                              │      SlackRequestDto.class
    │  │                              │
    │  │                              └─response
    │  │                                      QSlackResponseDto.class
    │  │                                      SlackResponseDto.class
    │  │
    │  ├─generated
    │  │  └─sources
    │  │      ├─annotationProcessor
    │  │      │  └─java
    │  │      │      └─main
    │  │      │          └─com
    │  │      │              └─logistics
    │  │      │                  └─platform
    │  │      │                      └─slack_service
    │  │      │                          ├─domain
    │  │      │                          │  └─model
    │  │      │                          │          QSlack.java
    │  │      │                          │
    │  │      │                          └─presentation
    │  │      │                              └─response
    │  │      │                                      QSlackResponseDto.java
    │  │      │
    │  │      └─headers
    │  │          └─java
    │  │              └─main
    │  ├─reports
    │  │  └─problems
    │  │          problems-report.html
    │  │
    │  ├─resources
    │  │  └─main
    │  │          application.yml
    │  │
    │  └─tmp
    │      └─compileJava
    │          │  previous-compilation-data.bin
    │          │
    │          └─compileTransaction
    │              ├─backup-dir
    │              └─stash-dir
    │                      AiController.class.uniqueId0
    │                      AiCreateRequest.class.uniqueId1
    │                      AiCreateResponse.class.uniqueId3
    │                      AiService.class.uniqueId2
    │
    ├─gradle
    │  └─wrapper
    │          gradle-wrapper.jar
    │          gradle-wrapper.properties
    │
    └─src
        ├─main
        │  ├─java
        │  │  └─com
        │  │      └─logistics
        │  │          └─platform
        │  │              └─slack_service
        │  │                  │  SlackServiceApplication.java
        │  │                  │
        │  │                  ├─application
        │  │                  │  └─service
        │  │                  │      ├─ai
        │  │                  │      │      AiService.java
        │  │                  │      │
        │  │                  │      ├─auth
        │  │                  │      │      AuthService.java
        │  │                  │      │      AuthServiceImpl.java
        │  │                  │      │
        │  │                  │      ├─message
        │  │                  │      │      MessageService.java
        │  │                  │      │      MessageServiceImpl.java
        │  │                  │      │
        │  │                  │      └─slack
        │  │                  │              SlackService.java
        │  │                  │
        │  │                  ├─common
        │  │                  │  │  ResponseDto.java
        │  │                  │  │
        │  │                  │  └─exception
        │  │                  │          CustomApiException.java
        │  │                  │          CustomExceptionHandler.java
        │  │                  │
        │  │                  ├─domain
        │  │                  │  ├─model
        │  │                  │  │      Slack.java
        │  │                  │  │
        │  │                  │  └─repository
        │  │                  │          SlackRepository.java
        │  │                  │
        │  │                  ├─infrastructure
        │  │                  │  ├─client
        │  │                  │  │      AuthClient.java
        │  │                  │  │
        │  │                  │  ├─configuration
        │  │                  │  │      CacheConfig.java
        │  │                  │  │      JpaConfig.java
        │  │                  │  │      RestTemplateConfig.java
        │  │                  │  │      SwaggerConfig.java
        │  │                  │  │
        │  │                  │  └─repository
        │  │                  │          SlackRepositoryCustom.java
        │  │                  │          SlackRepositoryCustomImpl.java
        │  │                  │
        │  │                  └─presentation
        │  │                      ├─controller
        │  │                      │      AiController.java
        │  │                      │      SalckController.java
        │  │                      │
        │  │                      ├─request
        │  │                      │      AiCreateRequest.java
        │  │                      │      SlackRequestDto.java
        │  │                      │
        │  │                      └─response
        │  │                              AiCreateResponse.java
        │  │                              SlackResponseDto.java
        │  │
        │  └─resources
        │          application.yml
        │
        └─test
            └─java
                └─com
                    └─logistics
                        └─platform
                            └─slack_service
                                    SlackServiceApplicationTests.java
```

## ⚙️ 실행 방법
- Java 17
- Docker에서 openzipkin/zipkin, redis 이미지 실행
- postgreSQL DB 설정 정보 환경변수에 등록
```
spring:
    datasource:
      driver-class-name: org.postgresql.Driver
      url: ${DB_URL} # jdbc:postgresql://localhost:5432/{DB이름}
      username: ${DB_USERNAME} # postgres
      password: ${DB_PASSWORD}
```

- 필요한 API KEY 환경변수에 등록
- hub-service : 구글 API KEY, 카카오 API KEY
```
google:
  maps:
    api:
      key: ${GOOGLE_API_KEY}

kakao:
  api:
    key: ${KAKAO_API_KEY}
```
  
- slack-service : 슬랙 봇 API KEY, 구글 Gemini API KEY
```
slack:
  bot:
    token: ${BOT_TOKEN}

google:
  gemini:
    api:
      key: ${GEMINI_TOKEN}
```

  
