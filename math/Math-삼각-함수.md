주어진 문제를 상세히 풀어보겠습니다. 문제는 삼각형 \(ABC\)에서 \(AD : DB = 3 : 2\)인 점 \(D\)를 선분 \(AB\) 위에 잡고, 점 \(A\)를 중심으로 하고 점 \(D\)를 지나는 원을 \(O\)라 한다. 원 \(O\)와 선분 \(AC\)가 만나는 점을 \(E\)라 할 때, \(\sin A : \sin C = 8 : 5\)이고, 삼각형 \(ADE\)와 삼각형 \(ABC\)의 넓이의 비가 \(9 : 35\)이다. 삼각형 \(ABC\)의 외접원의 반지름이 7일 때, 원 \(O\) 위의 점 \(P\)에 대하여 삼각형 \(PBC\)의 넓이의 최댓값을 구하는 것입니다.

## 1. 사인 법칙과 변수 설정
- 사인 법칙에 따라:
  \[
  \frac{a}{\sin A} = \frac{b}{\sin B} = \frac{c}{\sin C} = 2R = 14
  \]
  여기서 \(R = 7\)은 외접원의 반지름입니다.
  
- \(\sin A : \sin C = 8 : 5\)이므로:
  \[
  \sin A = \frac{8k}{14}, \quad \sin C = \frac{5k}{14}
  \]
  
- 변의 길이:
  \[
  AB = c = 2R \sin C = 14 \times \frac{5k}{14} = 5k
  \]
  \[
  AC = b = 2R \sin B = 14 \times \sin B
  \]
  \[
  BC = a = 2R \sin A = 14 \times \frac{8k}{14} = 8k
  \]

## 2. 넓이 비율
- 삼각형 \(ADE\)와 \(ABC\)의 넓이 비율이 \(9 : 35\)이므로:
  \[
  \frac{\text{Area of } \triangle ADE}{\text{Area of } \triangle ABC} = \frac{9}{35}
  \]
  
- \(AD : DB = 3 : 2\)이므로 \(AD = \frac{3}{5}AB = 3k\), \(DB = 2k\).

## 3. 헤론의 공식과 각 계산
- 삼각형 \(ABC\)의 변의 길이:
  \[
  AB = 5k, \quad BC = 8k, \quad AC = 7k
  \]
  
- 코사인 법칙을 이용하여 각 \(A\)를 계산:
  \[
  \cos A = \frac{b^2 + c^2 - a^2}{2bc} = \frac{49k^2 + 25k^2 - 64k^2}{2 \times 7k \times 5k} = \frac{10k^2}{70k^2} = \frac{1}{7}
  \]
  \[
  \sin A = \sqrt{1 - \cos^2 A} = \sqrt{1 - \frac{1}{49}} = \frac{4\sqrt{3}}{7}
  \]

## 4. 원 \(O\)의 좌표 설정
- 원 \(O\)의 반지름은 \(AD = 3k = 3\sqrt{3}\).
- 점 \(E\)의 좌표는 원 \(O\)와 선분 \(AC\)의 교점으로 계산됩니다.

## 5. 삼각형 \(PBC\)의 최대 넓이
- 점 \(P\)가 원 \(O\) 위에서 직선 \(BC\)까지의 거리를 최대화해야 합니다.
- 직선 \(BC\)의 방정식은 \(\sqrt{3}x + y - 15 = 0\).
- 원 위의 점 \(P\)에서 직선 \(BC\)까지의 최대 거리 계산:
  \[
  \text{최대 거리} = \frac{6\sqrt{3} + 15}{2}
  \]

## 6. 최대 넓이 계산
- 최대 거리를 이용한 삼각형 \(PBC\)의 넓이:
  \[
  \text{넓이} = \frac{1}{2} \times 8\sqrt{3} \times \frac{6\sqrt{3} + 15}{2} = 36 + 30\sqrt{3}
  \]

**최종 답**:
\[
\boxed{36 + 30\sqrt{3}}
\]



주어진 문제를 상세히 풀어보겠습니다. 문제는 삼각형 \(ABC\)에서 \(AD : DB = 3 : 2\)인 점 \(D\)를 선분 \(AB\) 위에 잡고, 점 \(A\)를 중심으로 하고 점 \(D\)를 지나는 원을 \(O\)라 한다. 원 \(O\)와 선분 \(AC\)가 만나는 점을 \(E\)라 할 때, \(\sin A : \sin C = 8 : 5\)이고, 삼각형 \(ADE\)와 삼각형 \(ABC\)의 넓이의 비가 \(9 : 35\)이다. 삼각형 \(ABC\)의 외접원의 반지름이 7일 때, 원 \(O\) 위의 점 \(P\)에 대하여 삼각형 \(PBC\)의 넓이의 최댓값을 구하는 것입니다.

### 1. 사인 법칙과 변수 설정
- 사인 법칙에 따라:
  \[
  \frac{a}{\sin A} = \frac{b}{\sin B} = \frac{c}{\sin C} = 2R = 14
  \]
  여기서 \(R = 7\)은 외접원의 반지름입니다.
  
- \(\sin A : \sin C = 8 : 5\)이므로:
  \[
  \sin A = \frac{8k}{14}, \quad \sin C = \frac{5k}{14}
  \]
  
- 변의 길이:
  \[
  AB = c = 2R \sin C = 14 \times \frac{5k}{14} = 5k
  \]
  \[
  AC = b = 2R \sin B = 14 \times \sin B
  \]
  \[
  BC = a = 2R \sin A = 14 \times \frac{8k}{14} = 8k
  \]

### 2. 넓이 비율
- 삼각형 \(ADE\)와 \(ABC\)의 넓이 비율이 \(9 : 35\)이므로:
  \[
  \frac{\text{Area of } \triangle ADE}{\text{Area of } \triangle ABC} = \frac{9}{35}
  \]
  
- \(AD : DB = 3 : 2\)이므로 \(AD = \frac{3}{5}AB = 3k\), \(DB = 2k\).

### 3. 헤론의 공식과 각 계산
- 삼각형 \(ABC\)의 변의 길이:
  \[
  AB = 5k, \quad BC = 8k, \quad AC = 7k
  \]
  
- 코사인 법칙을 이용하여 각 \(A\)를 계산:
  \[
  \cos A = \frac{b^2 + c^2 - a^2}{2bc} = \frac{49k^2 + 25k^2 - 64k^2}{2 \times 7k \times 5k} = \frac{10k^2}{70k^2} = \frac{1}{7}
  \]
  \[
  \sin A = \sqrt{1 - \cos^2 A} = \sqrt{1 - \frac{1}{49}} = \frac{4\sqrt{3}}{7}
  \]

### 4. 원 \(O\)의 좌표 설정
- 원 \(O\)의 반지름은 \(AD = 3k = 3\sqrt{3}\).
- 점 \(E\)의 좌표는 원 \(O\)와 선분 \(AC\)의 교점으로 계산됩니다.

### 5. 삼각형 \(PBC\)의 최대 넓이
- 점 \(P\)가 원 \(O\) 위에서 직선 \(BC\)까지의 거리를 최대화해야 합니다.
- 직선 \(BC\)의 방정식은 \(\sqrt{3}x + y - 15 = 0\).
- 원 위의 점 \(P\)에서 직선 \(BC\)까지의 최대 거리 계산:
  \[
  \text{최대 거리} = \frac{6\sqrt{3} + 15}{2}
  \]

### 6. 최대 넓이 계산
- 최대 거리를 이용한 삼각형 \(PBC\)의 넓이:
  \[
  \text{넓이} = \frac{1}{2} \times 8\sqrt{3} \times \frac{6\sqrt{3} + 15}{2} = 36 + 30\sqrt{3}
  \]

**최종 답**:
\[
\boxed{36 + 30\sqrt{3}}
\]

# **수학 - 삼각함수 (상세 풀이)**

주어진 문제의 그림과 조건에 따라 삼각형 \(PBC\) 넓이의 최댓값을 구하는 과정을 아주 자세히 설명합니다. 각 단계별 논리와 계산 과정을 최대한 상세하게 풀어서, 이해를 돕고자 합니다.

## 1. 문제 분석 및 기본 조건 정리

**주어진 조건:**

*   삼각형 \(ABC\)에서 \(\overline{AD} : \overline{DB} = 3 : 2\) 인 점 \(D\)가 선분 \(AB\) 위에 있습니다.
*   점 \(A\)를 중심으로 하고 점 \(D\)를 지나는 원 \(O\)가 있습니다.
*   원 \(O\)와 선분 \(AC\)가 만나는 점을 \(E\)라고 합니다.
*   \(\sin A : \sin C = 8 : 5\) 입니다.
*   \(\triangle ADE : \triangle ABC = 9 : 35\) 입니다.
*   삼각형 \(ABC\)의 외접원의 반지름의 길이는 7입니다. (\(R = 7\))
*   \(\overline{AB} < \overline{AC}\) 입니다.
*   원 \(O\) 위의 점 \(P\)에 대하여 삼각형 \(PBC\)의 넓이의 최댓값을 구해야 합니다.

**그림에 표시 및 추가 정보 도출:**

1.  **원 \(O\)의 성질:** 원 \(O\)는 점 \(A\)를 중심으로 하고 점 \(D\)를 지나므로, \(\overline{AD}\)는 원 \(O\)의 반지름입니다.  또한, 점 \(E\)도 원 \(O\) 위에 있으므로, \(\overline{AE}\)도 원 \(O\)의 반지름입니다. 따라서 \(\overline{AD} = \overline{AE}\) 입니다.

2.  **사인 법칙:** 삼각형 \(ABC\)에서 사인 법칙을 적용하면,
    \(\frac{\overline{BC}}{\sin A} = \frac{\overline{AB}}{\sin C} = \frac{\overline{AC}}{\sin B} = 2R\)
    여기서 \(R\)은 외접원의 반지름이고, \(R = 7\)이므로,
    \(\overline{BC} = 14\sin A\), \(\overline{AB} = 14\sin C\), \(\overline{AC} = 14\sin B\) 입니다.

3.  **선분 비율:** \(\overline{AD} : \overline{DB} = 3 : 2\) 이므로, \(\overline{AB}\)를 5등분했을 때 \(\overline{AD}\)는 3칸, \(\overline{DB}\)는 2칸에 해당합니다.  따라서,
    \(\overline{AD} = \frac{3}{5}\overline{AB}\), \(\overline{DB} = \frac{2}{5}\overline{AB}\) 입니다.

## 2. \(\triangle ADE\)와 \(\triangle ABC\)의 넓이 비 활용 (상세 풀이)**

\(\triangle ADE\)와 \(\triangle ABC\)는 각 \(A\)를 공통으로 가지고 있습니다.  삼각형의 넓이는 "(\(\frac{1}{2}\) × 두 변의 길이 × 끼인각의 사인)"으로 구할 수 있습니다.  따라서,

*   \(\triangle ADE\)의 넓이: \([\triangle ADE] = \frac{1}{2} \cdot \overline{AD} \cdot \overline{AE} \cdot \sin A\)
*   \(\triangle ABC\)의 넓이: \([\triangle ABC] = \frac{1}{2} \cdot \overline{AB} \cdot \overline{AC} \cdot \sin A\)

두 삼각형의 넓이 비는 다음과 같이 표현됩니다.

\(\displaystyle \frac{[\triangle ADE]}{[\triangle ABC]} = \frac{\frac{1}{2} \cdot \overline{AD} \cdot \overline{AE} \cdot \sin A}{\frac{1}{2} \cdot \overline{AB} \cdot \overline{AC} \cdot \sin A}\)

\(\frac{1}{2}\) 과 \(\sin A\)는 공통 인자이므로 약분됩니다.

\(\displaystyle \frac{[\triangle ADE]}{[\triangle ABC]} = \frac{\overline{AD} \cdot \overline{AE}}{\overline{AB} \cdot \overline{AC}} = \frac{\overline{AD}}{\overline{AB}} \times \frac{\overline{AE}}{\overline{AC}}\)

문제에서 \(\triangle ADE : \triangle ABC = 9 : 35\) 라고 주어졌으므로, \(\frac{[\triangle ADE]}{[\triangle ABC]} = \frac{9}{35}\) 입니다.

또한, 1단계에서 \(\overline{AD} = \frac{3}{5}\overline{AB}\) 임을 구했으므로, \(\frac{\overline{AD}}{\overline{AB}} = \frac{3}{5}\) 입니다.

이 값들을 넓이 비 식에 대입하면,

\(\displaystyle \frac{9}{35} = \frac{3}{5} \times \frac{\overline{AE}}{\overline{AC}}\)

\(\frac{\overline{AE}}{\overline{AC}}\) 를 구하기 위해 양변에 \(\frac{5}{3}\) 를 곱합니다.

\(\displaystyle \frac{\overline{AE}}{\overline{AC}} = \frac{9}{35} \times \frac{5}{3} = \frac{3}{7}\)

따라서 \(\overline{AE} : \overline{AC} = 3 : 7\) 입니다.  즉, \(\overline{AC}\)를 7등분했을 때 \(\overline{AE}\)는 3칸에 해당합니다.

\(\overline{AE} = \overline{AD}\) (원 \(O\)의 반지름) 이므로, \(\overline{AD} = \frac{3}{5}\overline{AB}\) 와 \(\overline{AE} = \frac{3}{7}\overline{AC}\) 라는 중요한 관계를 얻었습니다.

## 3. \(\sin A : \sin C = 8:5\) 와 \(\overline{AB} < \overline{AC}\) 조건 활용 (상세 풀이)**

\(\sin A : \sin C = 8 : 5\) 이므로, 비례상수 \(k\) (\(k > 0\))를 도입하여 \(\sin A = 8k\), \(\sin C = 5k\) 로 나타낼 수 있습니다.

\(\overline{AB} < \overline{AC}\) 이고, \(\overline{AB} = 14\sin C\), \(\overline{AC} = 14\sin B\) 이므로, \(14\sin C < 14\sin B\), 즉 \(\sin C < \sin B\) 입니다.

삼각형의 내각의 합은 \(180^\circ\) 이므로, \(A + B + C = 180^\circ\) 입니다.  \(A\), \(B\), \(C\)는 모두 삼각형의 내각이므로, \(0^\circ < A < 180^\circ\), \(0^\circ < B < 180^\circ\), \(0^\circ < C < 180^\circ\) 입니다.

**핵심:** 여기서 \(A = 90^\circ\) 라고 *가정하지 않고* 문제를 해결해야 합니다.  이전 풀이와의 차이점이 바로 이 부분입니다.

## 4. 변수 설정 및 관계식 도출

원 \(O\)의 반지름을 \(r\)이라고 설정합니다. 그러면 \(\overline{AD} = \overline{AE} = r\) 입니다.

\(\overline{AD} : \overline{DB} = 3:2\) 이므로, \(\overline{DB} = \frac{2}{3}r\) 입니다.  따라서 \(\overline{AB} = \overline{AD} + \overline{DB} = r + \frac{2}{3}r = \frac{5}{3}r\) 입니다.

\(\overline{AE} : \overline{AC} = 3:7\) 이고 \(\overline{AE} = r\) 이므로, \(\overline{AC} = \frac{7}{3}r\) 입니다.  \(\overline{CE} = \overline{AC} - \overline{AE} = \frac{7}{3}r - r = \frac{4}{3}r\) 입니다.  편의상 \(\overline{CE} = x\) 라고 놓으면, \(x = \frac{4}{3}r\) 입니다.

## 5. 넓이 비를 이용한 방정식 수립

\(\triangle ADE\)와 \(\triangle ABC\)의 넓이를 다시 한번 \(r\)과 \(\sin A\)를 이용하여 표현합니다.

*   \([\triangle ADE] = \frac{1}{2} \cdot \overline{AD} \cdot \overline{AE} \cdot \sin A = \frac{1}{2} \cdot r \cdot r \cdot \sin A = \frac{1}{2}r^2 \sin A\)
*   \([\triangle ABC] = \frac{1}{2} \cdot \overline{AB} \cdot \overline{AC} \cdot \sin A = \frac{1}{2} \cdot \frac{5}{3}r \cdot \frac{7}{3}r \cdot \sin A = \frac{35}{18}r^2 \sin A\)

주어진 넓이 비 \(\triangle ADE : \triangle ABC = 9:35\) 를 이용하면,

\(\frac{[\triangle ADE]}{[\triangle ABC]} = \frac{\frac{1}{2}r^2 \sin A}{\frac{35}{18}r^2 \sin A} = \frac{9}{35}\)

\(\sin A\) 와 \(r^2\)은 0이 아니므로 약분할 수 있습니다.

\(\frac{\frac{1}{2}}{\frac{35}{18}} = \frac{9}{35}\)

\(\frac{1}{2} \times \frac{18}{35} = \frac{9}{35}\)

\(\frac{9}{35} = \frac{9}{35}\)

이 식은 항등식이므로, 넓이 비 자체만으로는 \(r\) 값을 구할 수 없습니다.  다른 관계식을 찾아야 합니다.

## 6. 사인 법칙과 코사인 법칙 활용

\(\triangle ABC\)에서 사인 법칙을 적용하면,

\(\frac{\overline{BC}}{\sin A} = \frac{\overline{AB}}{\sin C} = 2R = 14\)

\(\overline{AB} = \frac{5}{3}r\) 이고, \(\sin A : \sin C = 8:5\) 이므로, \(\sin A = 8k\), \(\sin C = 5k\) 라고 하면,

\(\frac{\overline{BC}}{8k} = \frac{\frac{5}{3}r}{5k} = 14\)

\(\frac{\overline{BC}}{8} = \frac{\frac{1}{3}r}{1}  \implies \overline{BC} = \frac{8}{3}r\)

이제 \(\triangle ABC\)에서 코사인 법칙을 적용합니다.  \(\angle ACB = \theta\) 라고 하면,

\(\overline{AB}^2 = \overline{BC}^2 + \overline{AC}^2 - 2 \cdot \overline{BC} \cdot \overline{AC} \cdot \cos \theta\)

\(\overline{AB} = \frac{5}{3}r\), \(\overline{BC} = \frac{8}{3}r\), \(\overline{AC} = \frac{7}{3}r\) 를 대입하면,

\((\frac{5}{3}r)^2 = (\frac{8}{3}r)^2 + (\frac{7}{3}r)^2 - 2 \cdot \frac{8}{3}r \cdot \frac{7}{3}r \cdot \cos \theta\)

\(\frac{25}{9}r^2 = \frac{64}{9}r^2 + \frac{49}{9}r^2 - \frac{112}{9}r^2 \cos \theta\)

양변에 9를 곱하고 \(r^2\)으로 나누면 ( \(r \ne 0\) 이므로),

\(25 = 64 + 49 - 112 \cos \theta\)

\(112 \cos \theta = 88\)

\(\cos \theta = \frac{88}{112} = \frac{11}{14}\)

\(\sin^2 \theta + \cos^2 \theta = 1\) 이므로,

\(\sin \theta = \sqrt{1 - \cos^2 \theta} = \sqrt{1 - (\frac{11}{14})^2} = \sqrt{\frac{196 - 121}{196}} = \sqrt{\frac{75}{196}} = \frac{5\sqrt{3}}{14}\)

## 7. 외접원 반지름과 사인 법칙을 이용한 r 값 계산

\(\triangle ABC\)의 외접원의 반지름이 7이므로, 사인 법칙을 다시 적용합니다.

\(\frac{\overline{AB}}{\sin \theta} = 2R = 14\)

\(\overline{AB} = \frac{5}{3}r\) 이고, \(\sin \theta = \frac{5\sqrt{3}}{14}\) 이므로,

\(\frac{\frac{5}{3}r}{\frac{5\sqrt{3}}{14}} = 14\)

\(\frac{5}{3}r = 14 \cdot \frac{5\sqrt{3}}{14}\)

\(\frac{5}{3}r = 5\sqrt{3}\)

\(r = 3\sqrt{3}\)

## 8. 최대 높이 계산

점 A에서 선분 BC에 내린 수선의 발을 H라고 하면, \(\overline{AH}\)는 \(\triangle ABC\)의 높이입니다.

\(\overline{AH} = \overline{AC} \sin \theta = \frac{7}{3}r \cdot \sin \theta = \frac{7}{3} \cdot 3\sqrt{3} \cdot \frac{5\sqrt{3}}{14} = \frac{15}{2}\)

\(\triangle PBC\)의 넓이가 최대가 되려면, 점 P는 A에서 BC에 내린 수선의 연장선과 원 O가 만나는 점(Q)에 위치해야 합니다.  이때, \(\triangle PBC\)의 높이는 \(\overline{QH} = \overline{AH} + r\) 입니다.

\(\overline{QH} = \frac{15}{2} + 3\sqrt{3}\)

## 9. 최대 넓이 계산

\(\triangle PBC\)의 넓이의 최댓값은

\(\frac{1}{2} \times \overline{BC} \times \overline{QH} = \frac{1}{2} \times \frac{8}{3}r \times (\frac{15}{2} + 3\sqrt{3})\)

\(r = 3\sqrt{3}\) 을 대입하면,

\(\frac{1}{2} \times \frac{8}{3} \cdot 3\sqrt{3} \times (\frac{15}{2} + 3\sqrt{3}) = 4\sqrt{3} (\frac{15}{2} + 3\sqrt{3}) = 30\sqrt{3} + 36\)

## 10. 결론

따라서, \(\triangle PBC\) 넓이의 최댓값은 \(36 + 30\sqrt{3}\) 입니다.





---
잘못된 버전
---
 **수학- 삼각함수**

> [!Note]
> 아래 해결 과정을 하나씩 따라가면, 삼각형 \(PBC\)의 넓이 최댓값이 어떻게 나오고 왜 그 값이 되는지 알 수 있습니다.  
(※ 그림 속 표기는 문제 원문과 동일하게 유지하되, 각종 길이나 각도에 대한 보조표기를 추가하여 설명합니다.)



## 1. 기본 조건 정리

1. 삼각형 **$\(ABC\)$** 에 정의 된 조건
   - > $\\sin A : \sin C = 8  \\ : 5\$.
  
> [!Note]
> 외접원의 반지름 $\(r\)$ == 7이다
        
> [!Note]
> 즉, $\(\displaystyle BC = 2R \sin A = 14 \sin A,\; AB = 14 \sin C,\; AC = 14 \sin B.\)$

2. **선분 $\(AB\)$ 위의 점 $\(D\)$ 는 $\(AD : DB = 3 : 2\)$**.  
   - 따라서 $\(AB\)$를 5등분 했을 때
   - > $\(AD = \tfrac{3}{5}AB,\$; DB = $\tfrac{2}{5}AB.\)$

3. **$원\(O\)$** 는 “중심이 $\(A\)”$ 이고 “점을 $\(D\)$가 지나는 원”이다.
   - > 즉, $\(\text{반지름} = AD\).$  
   - 원 $\(O\)$가 선분 $\(AC\)$와 만나는 점을 $\(E\)$라 하였으므로,
   - > $\(\displaystyle AE = AD\).$

4. **문제에서 주어진 추가 정보**  
> [!Note] 
> - $\(\sin A : \sin C = 8 : 5\).$  
> - $\(\triangle ADE : \triangle ABC = 9 : 35.\)  $
> - $\(AB < AC\).  $
> - 원 $\(O\)$ 위 의 임의의 점 $\(P\)$를 잡았을 때, $\(\triangle PBC\)$의 넓이 중 최댓값을 구하라.

---

## 2. $\(\triangle ADE\)와 \(\triangle ABC\)의 넓이 비로부터 얻는 결과$

### 2.1 넓이 비의 기본 식
- $\(\triangle ABC\)$와 $\(\triangle ADE\)$ 는
- 공통으로 “각 $\(A\)”$ 를 끼고 있으므로,
  
   - > $\[
    \frac{[\triangle ADE]}{[\triangle ABC]} 
    \;=\;
    \frac{\tfrac12 \,(AD)\,(AE)\,\sin A}{\tfrac12 \,(AB)\,(AC)\,\sin A}
    \;=\;
    \frac{AD}{AB} \times \frac{AE}{AC}.
  \]$

- 문제에서
   - > $\(\triangle ADE : \triangle ABC = 9 : 35 \implies \tfrac{[\triangle ADE]}{[\triangle ABC]} = \tfrac{9}{35}.\)$

### 2.2 점 $\(D, E\)$ 의 정의에 따른 비율

1. $\(D\)는 \(AB\)$를 3:2로 나누므로,  
   - >   $\[
     \frac{AD}{AB} = \frac{3}{5}.
   \]$
   
2. $\(E\)$는 $\(AC\)$ 위에 있으면서 $\(AE = AD\)$.
   - 하지만 직접 $\(AE = \frac{3}{5}AB\)$ 라고 쓰기보다는,
   - **넓이 비**에서 얻는 식을 활용합니다.

> [!Note]
> 넓이 비 식에 대입하면
> $\[
  \frac{9}{35}
  \;=\;
  \bigl(\tfrac{AD}{AB}\bigr)
  \times
  \bigl(\tfrac{AE}{AC}\bigr)
  \;=\;
  \left(\frac{3}{5}\right)\,\times\,\left(\frac{AE}{AC}\right).
\]$

   - > 따라서
$\[
  \frac{AE}{AC} = \frac{9}{35} \;\Big/\; \frac{3}{5}
               = \frac{9}{35}\times \frac{5}{3}
               = \frac{45}{105}
               = \frac{3}{7}.
\]$

   - > 즉,
$\[
  AE : AC = 3 : 7.
\]$

그런데 $“\(AE = AD\)”이므로 \(AE = AD\)$. 
   - >결과적으로
$\[
  AD = \tfrac{3}{5}AB,\quad
  AE = \tfrac{3}{7}AC,\quad
  \text{그리고 } AD = AE.
\]$

---

## 3. $\(\sin A : \sin C = 8:5\)$와 $\(AB < AC\)$가 주는 힌트

### 3.1 각의 크기 유추
- $\(\sin A = 8k,\;$ $\sin C = 5k\)$라 놓으면 $(어떤 \(k > 0\))$  
  $\(\quad A = \arcsin(8k),\; C = \arcsin(5k).\)$
- $삼각형이므로 \(A + B + C = 180^\circ\)$. 따라서
  $\(\quad B = 180^\circ - (A + C).\)$

- 또한 $\(\sin B = \sin(A + C) = \sin A \cos C + \cos A \sin C.\)$

### 3.2 $\(AB < AC\)$의 의미
- $\(\displaystyle AB = 14\sin C,\; AC = 14\sin B\).  $
- $\(AB < AC \implies 14\sin C < 14\sin B \implies \sin C < \sin B.\)$
- 즉 $\(5k < \sin B\).$  

이 모든 조건을 만족하는 “최대” 상황을 살펴보면, 결국

> $\[
  \sin A = 1 \quad (\text{즉 } A=90^\circ), 
  \quad \sin C = \tfrac{5}{8},
  \quad \sin B = \sqrt{1 - \sin^2(90^\circ - C)} \dots
\]$

형태로 맞아떨어진다는 것을 확인할 수 있습니다

> [!Tip]
> 실제로 $\(A\)가 \(90^\circ\)가 되면, \(\sin A : \sin C = 1 : \tfrac{5}{8} = 8 : 5\) 성립). $

결과적으로 ** $\(A = 90^\circ\)$ **인 직각삼각형 형태가 
위 조건들을 모두 만족하면서

> [!Tip]
> 특히 $\(\triangle ADE : \triangle ABC = 9:35\$도 만족 
문제에서 요구하는 “최댓값”을 만들어냄을 알 수 있습니다.

> $직관적으로도, 각 \(A\)가 직각이면 \(\triangle ABC\)에서 \(BC\)가 지름(=14)이 되고,$
> $\(\triangle ADE\) 조건도 맞춰지면서 나머지 길이들이 특정 값들로 결정됩니다.$

---

## 4. 구체적 길이 계산 ( $\(A = 90^\circ\)$ 가정하에 )

### 4.1 삼각형 $\(ABC\)$의 변 길이
- $\(BC = 2R = 14\)$  (직각 대각선 = 지름)  
- $\(\sin C = \tfrac{5}{8} \implies AB = 14 \sin C = 14 \times \tfrac{5}{8} = 8.75.\)  $
- 각 $\(B = 90^\circ - C\)이므로 \(\sin B = \cos C = \sqrt{1 - \sin^2 C} = \sqrt{1 - (5/8)^2} = \sqrt{\tfrac{39}{64}} = \tfrac{\sqrt{39}}{8}.\)$  
  $\(\quad \therefore AC = 14 \sin B = 14 \times \tfrac{\sqrt{39}}{8} = \tfrac{7\sqrt{39}}{4}\approx 10.93.\)$

### 4.2 점 $\(D\)$의 위치
- $\(AB = 8.75\)$를 $\(3:2\)$로 나누므로,  
  $\(\displaystyle AD = \tfrac{3}{5} \times 8.75 = 5.25,\quad DB = 3.5.\)$
- 원 $\(O\)$의 반지름 $\(= AD = 5.25.\)$

### 4.3 높이 $\(A\)$에서 $\(BC\)$까지 수선   
- $\(\triangle ABC\)$에서 $\(A\)$가 직각이므로, $\(AB\)$와 $\(AC\)$가 각각 밑변·높이 역할을 할 수 있습니다.  
   - $\[
    [\triangle ABC] 
    = \frac12 \,(AB)\,(AC)
    = \frac12 \times 8.75 \times \bigl(\tfrac{7\sqrt{39}}{4}\bigr)
    \approx 47.8.
  \]$
- 이를 “밑변 $\(BC = 14\)$”로도 표현하면,
   -  $\[$  $[\triangle ABC]$  = $\tfrac12$ $\times BC$ $\times$ $(\text{A에서 BC까지의 수선 길이 }h)\$  ]
   - 따라서 
  $\[
    47.8 \approx \tfrac12 \times 14 \times h
    \;\;\Longrightarrow\;\;
    h \approx 6.83.
  \]$
  - 정확히 계산하면 $\(h = \tfrac{AB \cdot AC}{BC} = \tfrac{8.75 \times (7\sqrt{39}/4)}{14} = \tfrac{5\sqrt{39}}{32} \approx 6.83\)$.

---

## 5. $\(\triangle PBC\)$ 넓이의 최댓값

### 5.1 점 $\(P\)$의 위치와 “최대 높이” 아이디어

- 점 $\(P\)$는 “중심 $\(A\)$, 반지름 $\(AD=5.25\)$”인 원 위에 자유롭게 놓일 수 있습니다.  
- $\(\triangle PBC\)$의 밑변을 $\(BC\)$라 할 때, $\(\triangle PBC\)$의 넓이는
   - $\[\triangle PBC] = \tfrac12 \times BC \times (\text{BC에 대한 }P\text{의 수선거리}).\$
- $\(P\)$가 $\(A\)$를 중심으로 반지름 5.25인 원을 그린다고 할 때,

- **BC로부터 가장 멀리 떨어지는 점**이 넓이를 최대화합니다.  
   - 즉, “ $\(A\)$ 에서 $\(BC\)$ 까지의 거리 $(\(h \approx 6.83\))$ ”에다 “반지름 5.25”를 **같은 방향으로** 더한 길이가 $\(P\)$ 의 최대 수직거리.
      - 따라서 $\(BC\)$ 에 대한 최대 수직거리 = $\(h + AD = 6.83 + 5.25 \approx 12.08.\)$

### 5.2 넓이 계산
- 밑변 $\(BC = 14\).$  
- 최대 높이 $\(\approx 12.08.\)$  
- 넓이
  $\[
    [\triangle PBC]_{\max}
    = \tfrac12 \times 14 \times 12.08
    \;\approx\; 84.56.
  \]$

#### 5.2.1 정밀한 유리수·무리수 형태
- 수치 대신 기호로 정확히 계산하면

> [!note]
> $\[
  h 
  = \frac{5\sqrt{39}}{32},\quad
  AD 
  = 5.25 = \frac{21}{4}.
\]$
> 
> $\[
  h + AD 
  = \frac{5\sqrt{39}}{32} + \frac{21}{4}
  = \frac{5\sqrt{39}}{32} + \frac{168}{32}
  = \frac{5\sqrt{39} + 168}{32}.
\]$
> 
> $\[
  [\triangle PBC]_{\max}
  = \frac12 \times BC \times (h + AD)
  = \frac12 \times 14 \times \frac{5\sqrt{39} + 168}{32}
  = 7 \times \frac{5\sqrt{39} + 168}{32}
  = \frac{35\sqrt{39} + 1176}{32}.
\]$
- 이것을 조금 더 묶으면
$\[
  \frac{49}{32}\bigl(5\sqrt{39} + 24\bigr)
\]$
와 같이 쓸 수도 있습니다(둘 다 같은 값).

- 대략적으로 $\(\sqrt{39} \approx 6.245\)$ 이므로,
  $\[
    5\sqrt{39} + 24 \;\approx\; 31.225 + 24 = 55.225,\quad
    \frac{49}{32}\times 55.225 \;\approx\; 84.56.
  \]$
- 따라서 최댓값은 **약 $\(84.56\)$** 정도이고, 문제에서 “정확한 값”을 요구한다면  
   - >  $\[
    \boxed{\frac{49}{32}\bigl(5\sqrt{39} + 24\bigr)}
  $\]
  같은 꼴로 표현할 수 있습니다.

---

## 6. 요약

1. $\(\sin A : \sin C = 8 : 5\)$, $\(\triangle ADE : \triangle ABC = 9 : 35\)$ 등을 모두 만족하고 $\(AB < AC\)$가 되려면, 
   - > 결국 $\(\angle A = 90^\circ\)$인 직각삼각형 구도가 성립함을 알 수 있다. 
2. 그때 $\(BC = 14\),$ $\(AB = 8.75\),$ $\(AC \approx 10.93\),$ 그리고 $\(AD = 5.25\),$ $\(A\)$ 에서 $\(BC\)까지의$ 거리 $\(h \approx 6.83\)$ 등이 확정된다.  
3. $\(\triangle PBC\)의$ 넓이를 최대로 만들려면, $\(P\)가$ $\(BC\)와$ **가장 멀어지는 방향** 으로 놓여야 하고, 
   - > 그 최대 거리는 $\(h + AD \approx 12.08\).$  
4. 따라서 $\(\triangle PBC\)의$ 넓이 최댓값은 
   - $\[
     \frac12 \times BC \times \bigl(h + AD\bigr) 
     \;\approx\; 84.56,\]$
      - > 정확히는  $\[\boxed{\frac{49}{32}\bigl(5\sqrt{39} + 24\bigr)}\]$ 로 정리된다.
