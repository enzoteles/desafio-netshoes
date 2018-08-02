package br.com.netshoes.content

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */

interface ContentMVP{
    interface View {
        fun initInjection()
        fun initView()
        fun msgOfConnection()
    }
}