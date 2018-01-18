package com.cto3543.jc2co.ui.detail

import com.cto3543.jc2co.model.Station

class DetailPresenter : DetailContract.Presenter {
    override fun load(res: Station) {
        view?.load(res)
    }

    private var view: DetailContract.View? = null
    override fun attachView(view: DetailContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = view
    }
}