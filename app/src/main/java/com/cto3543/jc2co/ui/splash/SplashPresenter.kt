package com.cto3543.jc2co.ui.splash

class SplashPresenter : SplashContract.Presenter {
    override fun load() {
        view?.load("cycle_animation.json")
    }

    private var view: SplashContract.View? = null
    override fun attachView(view: SplashContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = view
    }
}