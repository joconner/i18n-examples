# JavaScript Libraries for Internationalization

![Vintage Map](images/vintage_map.jpg)
Creating a browser-based web application requires a combination of HTML, CSS, JavaScript, and backend services. Creating an internationalized application requires additional techniques and libraries to provide and manage localized data formats and resources. This document focuses just on front-end JavaScript needs.

Depending on your application, your internationalization needs will be different. However, common concerns include these issues:

* date, time, number, and currency formatting
* text localization
* pluralization and complex messages
* sorting and collation

More demanding use-cases may even require these:

* phone number formatting
* alternative calendars

Finally, considering that EcmaScript now includes an internationalization API that is already supported in Chrome and Firefox, I think the following is important:

* [Common Localization Data Repository](http://cldr.unicode.org/#TOC-What-is-CLDR-) (CLDR) format compliance
* [EcmaScript Intl API](http://www.ecma-international.org/flat/publications/Standards/Ecma-402.htm) compatibility

In my opinion, using a single library that supports all of the above is preferable to using multiple libraries. However, one solution doesn't always work for every situation and a single solution doesn't even seem to exist. You may have to use two or more different libraries to get all the functionality you need. For example, libraries that provide general number formatting support typically don't provide phone number support. 

Considering all the features above, you might consider these JavaScript internationalization libraries:

* EcmaScript Intl API
* [Intl.js](https://github.com/andyearnshaw/Intl.js)
* [JQuery Globalize](https://github.com/jquery/globalize) 
* [Format.js](http://formatjs.io/)
* [Dojo I18n](http://dojotoolkit.org/reference-guide/1.10/dojo/i18n.html)
* [LibPhoneNumber](https://code.google.com/p/libphonenumber/)

## EcmaScript Intl Library

EcmaScript, the language specification for JavaScript, has defined a new [Internationalization API](http://www.ecma-international.org/ecma-402/1.0/index.html). This API is already implemented in Chrome and Firefox browsers, and may be partially implemented in other browsers as well. The Internationalization API defines a new namespace *Intl* that provides objects for the following:

* collation
* number formatting
* date/time formatting

The new Intl library is extremely important because it means that you get some internationalization support without loading an external library. Additionally, implementations support the CLDR data, which is the best-practice for format patterns. 

Unfortunately, this API is not available in all browser-supplied JavaScript implementations, Safari and Internet Explorer being notable holdouts. Additionally, many mobile browsers do not yet provide the APIs.

If you need to use a separate library, you should favor those that provide a polyfill for this API when possible. This will make future transitions smoother.

## Intl.js

The [Intl.js](https://github.com/andyearnshaw/Intl.js) library is a polyfill for the EcmaScript Intl library. It provides the number and date/time formatting APIs. However, it does not provide the collation API. Because it uses CLDR data, you can feel comfortable that the actual formats created by this library will be the same as--or very similar to--the EcmaScript Intl library. However, because collation isn't available, you obviously have to look elsewhere if that is needed. If you don't need collation, this may be a good option for basic data formatting.

## Globalize.js

The[JQuery Globalize](https://github.com/jquery/globalize) library now provides CLDR support. It also provides the number, date, and time formatting. However, it gives you a couple additional features above Intl.js that make it worth considering:

* message translation API
* pluralization

Message translation is a localization API for common message strings. The library defines a file format for translatable message strings and gives you API for retrieving those strings after translation.

Pluralization is a feature that lets you accommodate the differences in word choice that are needed when word forms depend on their count. For example, the pluralization library let's you conveniently handle word choice for 0, 1, or n number of *mouse* or *mice*. Both Polish and Russian, for example, have several plural forms for 2, 3, 4, 5, or even more instances of a particular noun.

## Format.js

The [Format.js](http://formatjs.io/) library was recently released by Yahoo. It builds upon the Intl.js library and adds support for the following:

* support for template libraries like Handlebars, React, and Dust
* cache support for Intl format objects
* ICU message syntax for pluralization, gender, and other types of message variability
* relative time (5 min ago, 2 hours ago, etc)

The set of APIs is modular. If you only need the relative time support, you can load just that library instead of other items.

## Dojo I18n

If you are already using Dojo, Dojo's own internationalization libraries are an obvious choice. With support for string resource bundles, date and time formatting, and number and currency formatting, Dojo's library has a lot to offer. This library's additional benefit is its support for the CLDR patterns.

## Phone Number Library

The *libphonenumber* library solves a very specific need for phone number parsing and formatting. If your application needs this, this well-supported library from Google should handle your common use-cases. In addition to JavaScript, the library exists for Java, C++, and other languages. The library helps you parse, format, and validate phone numbers for many countries of the world. Surprisingly, the library also helps you determine the type of a phone number, for example, fixed-line, mobile, toll-free, etc.
 
## Conclusions

No single JavaScript library exists for all internationalization needs. However, you should be able to use one of either Intl.js, Globalize.js, Format.js, or Dojo for basic data formatting. For phone numbers, the *libphonenumber* library seems to be the only real choice for now, but it seems to be well supported and adequate for many use cases. Unfortunately, I haven't found a widespread collation solution yet. However, given the typical size and download-time constraints for JavaScript applications, especially in mobile settings, sorting on the server side before transmitting sortable data may be a better solution for now.
 
 Good luck in your own internationalization work in JavaScript. If you haven't already adopted a set of support libraries, consider some of the ones mentioned above.
 