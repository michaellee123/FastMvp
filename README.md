# FastMvp

## Import

If you use `JCenter`, add this code in your gradle file.

```gradle
dependencies {
    implementation 'dog.abcd:fastmvp:1.0.0'
}
```

Also you can use `jitpack.io`, you need add this code in your gradle file.

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
        implementation 'com.github.michaellee123:FastMvp:1.0.0'
}
```

## How To Use

1. Create your `IBaseView` like this:

```kotlin
interface IBaseView : IFastView {
    // Some method you want use in everywhere
    fun getContext(): Context?
    fun getLifecycleOwner(): LifecycleOwner?
    fun getBundle(): Bundle?
    fun finishActivity() {}
}
```

2. Create your `BaseMvpActivity` like this:

```kotlin
//The BaseActivity is yourself BaseActivity
abstract class BaseMvpActivity<K : IBaseView, T : FastPresenter<K>> : BaseActivity(),IFastMVP<K,T> {

    override lateinit var presenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Will bind presenter and call lifecycle.addObserver
        bindPresenter()
    }

    override fun lifecycle(): Lifecycle = lifecycle

}
```
Now, you can use MVP in your project.

## Demo

1. View interface

```kotlin
interface ITestView : IBaseView {
    fun getTextView(): TextView
    fun showToast(message: String)
}
```

2. Presenter

```kotlin
class TestPresenter : FastPresenter<ITestView>() {
    
    override fun onBindView() {
        view?.getTextView()?.text = "Hello World"
    }

    // You can do something with lifecycle callback
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        view?.showToast("onResume")
    }
}
```

3. Activity

```kotlin
class TestActivity : BaseMvpActivity<ITestView, TestPresenter>(), ITestView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun layoutId(): Int {
        return R.layout.activity_text
    }

    override fun getTextView(): TextView {
        return textView
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
```

That's All!