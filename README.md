## Dropwizard, Gradle, and Angular

This is source for my talk on Dropwizard and Gradle. The Angular content is
here, works, and is tested, but is not part of the talk.

* Slideshow presentation (built w/ [Remark.js](https://github.com/gnab/remark)):
    * http://cholick.github.io/dropwizard-gradle-angular
* Markdown version of the slides:
    * http://cholick.github.io/dropwizard-gradle-angular/dropwizard.md

#### Running
```
./gradlew run
```
App is running on [http://localhost:9000](http://localhost:9000)

#### References
* Dropwizard
    * [Validator snipper](https://gist.github.com/nicktelford/3867771)
    * [Testing wiki](https://github.com/dropwizard/dropwizard/blob/master/docs/source/manual/testing.rst)
    * [Configuration reference](https://github.com/grahamoregan/dropwizard/blob/master/docs/source/manual/configuration.rst#simple)
* Gradle
    * [Building JS webapps with Gradle](http://blog.shinetech.com/2014/03/19/javascript-webapps-with-gradle/)
* Angular
    * [Angular Style guide](https://github.com/johnpapa/angularjs-styleguide)
    * [Settings up Jasmine in IntelliJ](http://tatiyants.com/how-to-configure-intellij-idea-for-angular-js-testing/)
    * [Todo MVC angular example](http://todomvc.com/architecture-examples/angularjs/#/active)
    * [Angular routing and templating](http://scotch.io/tutorials/javascript/single-page-apps-with-angularjs-routing-and-templating)
* Other
    * [ASCII text generator](http://patorjk.com/software/taag/#p=display&f=ANSI%20Shadow&t=To-Do%20App)

#### Todo
* Setup PhantomJS as part of Gradle build
* Pre-compiled Angular templates
* Minified JS and CSS for Jar (with source maps)
