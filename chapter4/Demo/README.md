# 时钟APP

3个todo处添加的内容：

- todo1

```java
// todo 1: 每一秒刷新一次，让指针动起来
// handler和redrawRunnable被提至了成员变量，避免反复new对象

/* handler和redraw的定义
private Runnable redrawRunnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };
private Handler handler = new Handler();
*/

handler.postDelayed(redrawRunnable, 1000);
```

- todo2
```java
// todo 2: 画分针
drawPointer(canvas, 1, nowMinutes);
```

- todo3
```java
// todo 3: 画分针，设置分针的颜色
degree = value * UNIT_DEGREE;   // 将60进制的分钟值映射到360度的角度刻度上
mNeedlePaint.setColor(Color.BLUE);  // 颜色设置为蓝色
pointerHeadXY = getPointerHeadXY(MINUTE_POINTER_LENGTH, degree); // 求分针头的位置
break;
```
