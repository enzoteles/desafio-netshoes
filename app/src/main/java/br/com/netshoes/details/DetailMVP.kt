package br.com.netshoes.details

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
interface DetailMVP{
    interface View{
        fun initInjection()
        fun initView()
        fun initData()
    }
    interface Presenter
    interface Interactor
}