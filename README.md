# FindRandom

[![](https://jitpack.io/v/mohamadreza7565/SpannableWord.svg)](https://jitpack.io/#mohamadreza7565/SpannableWord)



# Gradle

## Dependency
```Gradle
dependencies {
	implementation 'com.github.mohamadreza7565:SpannableWord:1.3.0'
	}
```


## Maven
```Gradle
allprojects {
     repositories {
	...
     maven { url 'https://jitpack.io' }
	}
}
```

### Examples

```java

   SpannableWords spanOne = new SpannableWords()
                .append("Hello", new StyleSpan(Typeface.BOLD_ITALIC))
                .append(" my", new StyleSpan(Typeface.BOLD_ITALIC))
                .append(" friends", new ForegroundColorSpan(Color.RED));

```


```java

 SpannableWords spanTwo = new SpannableWords(text).findAndSpan("friends", new SpannableWords.GetSpan() {
            @Override
            public Object getSpan() {
                return new StyleSpan(Typeface.BOLD_ITALIC);
            }
        });

```

```java

  SpannableWords spanTwo = new SpannableWords(text).findAndSpan("friends", false, true, new SpannableWords.GetSpan() {
            @Override
            public Object getSpan() {
                return new StyleSpan(Typeface.BOLD_ITALIC);
            }
        });

```
