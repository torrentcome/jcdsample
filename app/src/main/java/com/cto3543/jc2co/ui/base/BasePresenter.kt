package com.cto3543.jc2co.ui.base

interface BasePresenter<in T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}