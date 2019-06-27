package com.sample

interface BaseView<T> {
    fun setPresenter(presenter:T)
}

interface BasePresenter{
    fun start()
}

interface DataSources{
    fun makeARequest()

}