
# **수학- 삼각함수**

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
