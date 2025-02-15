#!/bin/bash

# 설치할 Maven 버전 설정
MAVEN_VERSION=3.9.9
MAVEN_DIR=/opt/maven

# 기존 Maven 제거
sudo apt remove -y maven

# 필요한 패키지 설치
sudo apt update
sudo apt install -y wget tar

# Maven 다운로드
wget https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz

# 압축 해제
sudo mkdir -p ${MAVEN_DIR}
sudo tar -xzvf apache-maven-${MAVEN_VERSION}-bin.tar.gz -C ${MAVEN_DIR}
sudo ln -s ${MAVEN_DIR}/apache-maven-${MAVEN_VERSION} ${MAVEN_DIR}/latest

# 환경 변수 설정
echo "export M2_HOME=${MAVEN_DIR}/latest" | sudo tee /etc/profile.d/maven.sh
echo "export PATH=\$M2_HOME/bin:\$PATH" | sudo tee -a /etc/profile.d/maven.sh

# 권한 설정 및 적용
sudo chmod +x /etc/profile.d/maven.sh
source /etc/profile.d/maven.sh

# 설치 확인
mvn -version

# 정리
rm apache-maven-${MAVEN_VERSION}-bin.tar.gz

echo "Maven ${MAVEN_VERSION} 설치 완료"
