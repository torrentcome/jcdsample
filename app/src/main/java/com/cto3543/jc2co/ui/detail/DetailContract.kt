package com.cto3543.jc2co.ui.detail

import com.cto3543.jc2co.model.Station
import com.cto3543.jc2co.ui.base.BasePresenter
import com.cto3543.jc2co.ui.base.BaseView

interface DetailContract {
    interface View : BaseView {
        fun load(res: Station)
    }

    interface Presenter : BasePresenter<View> {
        fun load(res: Station)
    }
}