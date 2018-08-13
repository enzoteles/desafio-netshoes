package br.com.netshoes.content.di

import br.com.netshoes.about.AboutFragment
import br.com.netshoes.about.AboutMVP
import br.com.netshoes.favorites.FavoritesFragment
import br.com.netshoes.favorites.FavoritesMVP
import br.com.netshoes.home.HomeFragment
import br.com.netshoes.home.HomeMVP
import dagger.Module
import dagger.Provides

/**
 * Created by Enzo Teles on 30,July,2018
 * Barueri - SP
 * email: enzo.carvalho.teles@gmail.com
 * Software Developer Sr.
 */
@Module
class ContentModule(){

    /**
     * method that provides the instance of the home screem
     * @return
     * */
    /*@Provides
    fun provideHomeFragment(): HomeMVP.View{
        return  HomeFragment()
    }*/


    /**
     * method that provides the instance of the favorites screem
     * @return
     * */

    @Provides
    fun provideFavoritesFragment(): FavoritesMVP.View{
        return  FavoritesFragment()
    }


    /**
     * method that provides the instance of the about screem
     * @return
     * */
    @Provides
    fun provideAboutFragment(): AboutMVP.View{
        return  AboutFragment()
    }

}