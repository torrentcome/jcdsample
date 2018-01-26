package com.cto3543.jc2co.ui.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.cto3543.jc2co.App
import com.cto3543.jc2co.R
import com.cto3543.jc2co.extention.void
import com.cto3543.jc2co.ui.list.ListActivity
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashContract.View {
    @Inject
    lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        DaggerSplashComponent.builder()
                .appComponent((application as App).appComponent())
                .splashModule(SplashModule())
                .build()
                .inject(this)

        splashPresenter.attachView(this)
        splashPresenter.load()
    }

    override fun onDestroy() {
        super.onDestroy()
        splashPresenter.detachView()
    }

    override fun load(anim: String) {
        animation_view.setAnimation(anim)
        animation_view.loop(false)
        animation_view.playAnimation()
        animation_view.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) = Unit.void()
            override fun onAnimationCancel(p0: Animator?) = Unit.void()
            override fun onAnimationStart(p0: Animator?) = Unit.void()
            override fun onAnimationEnd(p0: Animator?) = goTo()
        })
        textView.text = getString(R.string.app_name)
    }

    override fun showError(error: String) = Snackbar.make(list, error, Snackbar.LENGTH_LONG).show()
    fun goTo() = startActivity(Intent(applicationContext, ListActivity::class.java))
}
