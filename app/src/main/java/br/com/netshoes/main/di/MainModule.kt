package br.com.netshoes.main.di

import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.netshoes.content.ContentFragment
import br.com.netshoes.content.ContentMVP
import br.com.netshoes.main.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Module
class MainModule(val activity: MainActivity){

    /**
     * method that provides the instance of the view
     * @return
     * */
    @Provides
    fun provideContentFragment(): ContentMVP.View{
        return  ContentFragment()
    }

    @Provides
    fun provideHelpManagerFragment(): HelpManagerFragment {
        return  HelpManagerFragment(activity)
    }

}