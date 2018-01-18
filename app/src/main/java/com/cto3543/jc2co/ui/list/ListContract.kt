package com.cto3543.jc2co.ui.list

import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.base.BasePresenter
import com.cto3543.jc2co.ui.base.BaseView

interface ListContract {
    interface View : BaseView {
        fun showRes(res: List<Station>)
        fun showProgress(show: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun loadRes()
    }
}