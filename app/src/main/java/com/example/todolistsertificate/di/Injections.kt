package com.example.todolistsertificate.di

import com.example.todolistsertificate.data.local.LocalStorage
import com.example.todolistsertificate.di.network.*
import com.example.todolistsertificate.domain.MainRepository
import com.example.todolistsertificate.domain.impl.MainRepositoryImpl
import com.example.todolistsertificate.presenter.CreateTodoViewModel
import com.example.todolistsertificate.presenter.HomeViewModel
import com.example.todolistsertificate.presenter.LoginViewModel
import com.example.todolistsertificate.presenter.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { HomeViewModel(get()) }
    viewModel { CreateTodoViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }

}

val repositoryModule = module{
    single<MainRepository> {MainRepositoryImpl(get(), get())}
}

val networkModule = module {
    factory { AuthInterceptor(get()) }
    factory { provideOkHttpClient(get()) }
    factory { provideTodoApi(get()) }
    single { provideRetrofit(get()) }
}

val localStorageModule = module {
    single { LocalStorage() }
}