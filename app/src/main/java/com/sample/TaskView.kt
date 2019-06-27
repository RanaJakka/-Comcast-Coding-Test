package com.sample

interface TaskView<T:TaskPresenter>:BaseView<T> {
    fun showProgressBar()
    fun hideProgressBar()
    fun loadData()// need to pass the listof data

}

interface TaskPresenter:BasePresenter{
    fun filterTheKeyWord()
    fun notifyDataRepo(data:TaskModel)

}


