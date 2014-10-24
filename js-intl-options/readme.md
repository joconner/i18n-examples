# JavaScript Libraries for Internationalization

Creating a web application requires a combination of HTML, CSS, JavaScript, and backend services. Creating an internationalized application requires additional techniques and libraries to provide and manage localized data formats and resources. This document concentrates on JavaScript needs.

Creating your own solutions is always a tempting option. However, I think a quicker and more reliable option for internationalization is to find and use an existing library. When picking a library, look for the following features:

* localized text support
* date, time, number, and currency format support
* phone number format support
* pluralization, gender, complex message support
* Common Localization Data Repository (CLDR) usage
* EcmaScript Intl compatibility
* data validation support
* calendar options
* sort and collation support
* modular configuration and download options


In my opinion, using a single library that supports all of the above is preferable to using multiple libraries. However, one solution doesn't always work for every situation. For example, a mobile application may not want or need the typically large-sized collation support in its libraries.

Considering the features above, you might consider these JavaScript internationalization libraries:

* [EcmaScript Intl]
* [YUI](http://yuilibrary.com/yui/docs/intl/)
* [Intl.js](https://github.com/andyearnshaw/Intl.js)
* [Globalize.js](https://github.com/jquery/globalize)
* [iLib](http://sourceforge.net/projects/i18nlib/)
* [Dojo](http://dojotoolkit.org/documentation/tutorials/1.9/i18n/)
* [Locale Planet](http://www.localeplanet.com/)

## EcmaScript Intl Library
