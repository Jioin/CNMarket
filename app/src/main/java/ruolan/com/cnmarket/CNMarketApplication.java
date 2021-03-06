package ruolan.com.cnmarket;

import android.app.Application;
import android.content.Context;

import ruolan.com.cnmarket.di.component.AppComponent;
import ruolan.com.cnmarket.di.component.DaggerAppComponent;
import ruolan.com.cnmarket.di.module.AppModule;
import ruolan.com.cnmarket.di.module.HttpModule;


public class CNMarketApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this))
                .httpModule(new HttpModule()).build();
    }

    public static CNMarketApplication getApplication(Context context){
        return (CNMarketApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
