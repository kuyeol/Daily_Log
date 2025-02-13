---
layout: home
title: My Tech Blog
description: 개발 경험과 기술을 공유하는 블로그입니다
---

# Welcome to My Tech Blog

안녕하세요! 이 블로그는 개발 여정과 기술적 통찰을 공유하는 공간입니다.

## Recent Projects

### 🚀 Project Name 1
- 프로젝트 소개와 주요 기능
- 사용된 기술 스택: React, Node.js, MongoDB
- [GitHub Repository](https://github.com/username/project1)

### 💻 Project Name 2
- 프로젝트 설명
- 구현된 핵심 기능들
- [Live Demo](https://project2-demo.com)

## Technical Skills

### Frontend
- HTML5, CSS3, JavaScript (ES6+)
- React.js, Vue.js
- Tailwind CSS, Sass

### Backend
- Node.js, Express
- Python, Django
- RESTful API Design

### DevOps & Tools
- Git, GitHub Actions
- Docker, Kubernetes
- AWS, GCP

## Latest Blog Posts

최근 작성된 기술 블로그 포스트들을 확인해보세요.

{% for post in site.posts limit:5 %}
- [{{ post.title }}]({{ post.url | relative_url }}) - {{ post.date | date: "%Y-%m-%d" }}
{% endfor %}

## Contact & Links

- 📧 Email: [your.email@example.com](mailto:your.email@example.com)
- 💼 LinkedIn: [Your Name](https://linkedin.com/in/yourname)
- 🐱 GitHub: [@username](https://github.com/username)
- 📝 Blog: [Tech Blog](https://yourblog.com)

---

> "코드는 시가 아닙니다. 가능한 한 명확하게 작성되어야 합니다." - Guido van Rossum

---

<div style="text-align: center; margin-top: 50px;">
  <p>
    이 블로그는 Jekyll과 GitHub Pages로 제작되었습니다.<br>
    © 2024 Your Name. All rights reserved.
  </p>
</div>
