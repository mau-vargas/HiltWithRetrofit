package com.example.hiltwithretrofit.component

import android.content.Context
import com.example.hiltwithretrofit.di.RetrofitModule
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [RetrofitModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(retrofitModule: RetrofitModule): Builder
        fun build(): AppComponent
    }
}
