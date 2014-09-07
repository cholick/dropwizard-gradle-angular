package com.cholick.todo

import com.cholick.todo.resources.TodoResource
import com.google.inject.Guice
import com.google.inject.Injector
import io.dropwizard.Application
import io.dropwizard.assets.AssetsBundle
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args)
    }

    @Override
    void initialize(Bootstrap<AppConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle('/assets/', '/'));
    }

    @Override
    void run(AppConfiguration configuration, Environment environment) throws Exception {
        Injector injector = Guice.createInjector()

        environment.lifecycle().manage(injector.getInstance(Startup))
        environment.healthChecks().register('basic', new BasicHealthCheck())

        environment.jersey().urlPattern = '/api/*'
        environment.jersey().register(injector.getInstance(TodoResource))
    }

}
