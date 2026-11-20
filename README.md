# 39-COLLABORATION-ANDROID-CATCHTABLE

합동세미나 앱 2조 캐치테이블 안드로이드 레포지토리입니다

<br>

## 📌 프로젝트 소개
캐치테이블의 홈, 가게 상세, 친구와 함께 가게를 고르는 투표 경험을 구현한 Android 프로젝트입니다.

<img width="1920" height="1080" alt="표지" src="https://github.com/user-attachments/assets/0468cd7e-8790-49ed-a70f-70732fa17c25" />


<br>

## 👥 팀원 및 역할

| 최은지 (LEAD) | 김별 | 김승혁 | 신승연 |
| :---: | :---: | :---: | :---: |
| <img width="200" alt="최은지" src="https://github.com/user-attachments/assets/6efb9d2c-5132-4caf-b8de-d26a03bf36e1" /> | <img width="200" alt="김별" src="https://github.com/user-attachments/assets/93cdfb42-1d51-4fbc-a379-295c02550227" /> | <img width="200" alt="김승혁" src="https://github.com/user-attachments/assets/1e749323-edab-4f49-b9c7-122abe41ad28" /> | <img width="200" alt="신승연" src="https://github.com/user-attachments/assets/203e2ff7-6560-42f5-a694-e242b52741f8" /> |
| [@chldmswll](https://github.com/chldmswll) | [@byul227](https://github.com/byul227) | [@seongh06](https://github.com/seongh06) | [@shinisme](https://github.com/shinisme) |
| 프로젝트 세팅, 네비게이션,<br>투표 제출·투표 완료 뷰<br>및 투표 제출 API 연동<br>README 작성 | 가게 상세 뷰<br>및<br>가게 상세 API 연동 | 디자인 시스템 세팅<br>투표 상세 뷰<br>및<br>투표 생성·상세 조회 API 연동 | 홈 뷰<br>및<br>진행 중인 투표 조회 API 연동 |



<br>

## 📱 구현 화면 및 시연

### 주요 화면

| 홈 (default) | 홈 (진행 중인 투표 O) | 가게 상세 |
| :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/96e7a50e-91f0-425c-bccc-f1766825fcc5" width="200"/> | <img src="https://github.com/user-attachments/assets/d39a029e-d37f-4386-9e85-9e6171a91ad0" width="200"/> | <img src="https://github.com/user-attachments/assets/0b781b68-2199-47bd-b7b8-ccf6f2c9972d" width="200"/> |

| 함께 고르기 (투표 생성 완 / 매장 선택 전) | 함께 고르기 (투표 생성) | 함께 고르기 (매장 선택) |
| :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/0c327779-3681-4a25-9fd1-8fbb64f6530c" width="200"/> | <img src="https://github.com/user-attachments/assets/c3eb656d-5289-4bc3-9f02-8f4f860e2755" width="200"/> | <img src="https://github.com/user-attachments/assets/4b7d85bc-a811-4a22-be0e-09bb3b88e595" width="200"/> |

| 투표 하기 (익명) | 투표 하기 (닉네임) | 함께 고르기 (투표 종료) |
| :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/c9266303-2fc6-41aa-8af5-d662a9e62f28" width="200"/> | <img src="https://github.com/user-attachments/assets/13bacd00-eac7-447d-b205-9c1db6439352" width="200"/> | <img src="https://github.com/user-attachments/assets/45b7f517-25d1-4e5a-b045-c4a1a3614810" width="200"/> |



### 시연 영상

<video src="https://github.com/user-attachments/assets/8b0bdcd0-7735-470c-8728-399e8b3f9049" width="200"/>



<br>

## 🛠 기술 스택

| 구분 | 기술 |
| --- | --- |
| Language | Kotlin |
| UI | Jetpack Compose, Material 3, Coil, Haze |
| Architecture | Clean Architecture, MVVM, Single Activity Architecture |
| Dependency Injection | Hilt |
| Asynchronous | Kotlin Coroutines, Flow, StateFlow |
| Network | Retrofit2, OkHttp3, Kotlinx Serialization |
| Navigation | Navigation Compose (Type-safe) |
| Logging | Timber |
| CI | GitHub Actions (PR 빌드 체크) |

## 📂 패키지 구조

```
📦 com.android.catchtable
├── 📄 CatchTableApplication.kt      # Hilt Application
├── 📁 data                          # 데이터 계층
│   ├── 📁 mapper                    # DTO → domain Model 변환
│   ├── 📁 remote
│   │   ├── 📁 dto                   # 요청·응답 JSON 구조
│   │   │   ├── 📁 base              # BaseResponse, ErrorResponse
│   │   │   ├── 📁 home
│   │   │   ├── 📁 store
│   │   │   └── 📁 vote
│   │   ├── 📁 interceptor           # X-User-Id 헤더 추가
│   │   └── 📁 service               # Retrofit API 선언
│   ├── 📁 repositoryimpl            # Repository 구현체
│   └── 📁 util                      # suspendRunCatching, getDataOrThrow, Json 설정
├── 📁 di                            # Network, Service, Repository Hilt 모듈
├── 📁 domain                        # 도메인 계층 (다른 계층에 의존하지 않음)
│   ├── 📁 exception                 # ApiException
│   ├── 📁 model                     # 앱의 핵심 데이터
│   │   ├── 📁 home
│   │   ├── 📁 store
│   │   └── 📁 vote
│   ├── 📁 repository                # Repository 인터페이스
│   └── 📁 usecase                   # 비즈니스 동작 단위
│       ├── 📁 home
│       ├── 📁 store
│       └── 📁 vote
└── 📁 presentation                  # UI 계층
    ├── 📁 common                    # 공통 UI
    │   ├── 📁 component             # CatchTable 공통 컴포넌트
    │   ├── 📁 extension             # Modifier 확장 함수
    │   ├── 📁 model                 # 공통 UI 모델
    │   ├── 📁 state                 # UiState
    │   └── 📁 theme                 # Color, Typography, Theme
    ├── 📁 main                      # MainActivity, NavHost, 하단 네비게이션 바
    ├── 📁 navigation                # MainTabRoute, Route 정의
    ├── 📁 home                      # 홈
    ├── 📁 store                     # 가게 상세
    ├── 📁 vote                      # 투표 생성·참여·종료
    ├── 📁 votecomplete              # 투표 완료
    ├── 📁 saved                     # 저장 탭
    ├── 📁 nearby                    # 내 주변 탭
    ├── 📁 dining                    # 마이다이닝 탭
    └── 📁 my                        # MY 탭
```



## 🌿 브랜치 컨벤션

| 브랜치 | 용도 |
| --- | --- |
| main | 완성된 버전의 코드를 저장하는 브랜치 |
| develop | 개발이 진행되는 동안 완성된 코드를 저장하는 브랜치 |
| feature | 작은 단위의 작업이 진행되는 브랜치 |
| hotfix | 긴급한 오류를 해결하는 브랜치 |

### 브랜치명

```
유형/#이슈번호-작업내용
```

| 카테고리 | 의미 |
| --- | --- |
| feat | 구현 |
| mod | 수정 |
| add | 추가 |
| del | 삭제 |
| fix | 버그 수정 |
| refactor | 리팩토링 |

<br>

## 💬 커밋 컨벤션

```
[커밋 카테고리/#이슈번호] 커밋 내용
```

| 카테고리 | 의미 |
| --- | --- |
| feat | 새로운 기능 구현 |
| mod | 코드 수정 |
| add | feat 이외의 부수적인 코드 추가, 라이브러리 추가 |
| del | 쓸모없는 코드 삭제 |
| chore | 변수명 및 함수명 수정과 같은 사소한 수정 |
| fix | 버그 수정 |
| docs | 문서 추가, 수정, 삭제 |
| init | 프로젝트 초기 세팅 |

### 머지 커밋

| 상황 | 커밋 메시지 |
| --- | --- |
| PR을 develop에 머지할 때 | `[MERGE] #이슈번호 -> develop` |
| develop을 내 브랜치로 pull 받을 때 | `[merge/#내 브랜치 이슈번호] pulled develop` |

### 협업 규칙

- develop 브랜치에서 직접 작업하지 않습니다.
- 본인의 Pull Request는 본인이 merge합니다.
- Commit, Push, Merge, Pull Request는 앱이 정상적으로 빌드·실행되는지 확인한 뒤 진행합니다.
- PR은 PR CI(빌드 체크)를 통과해야 합니다.
