# JavaScript Libraries for Internationalization

Creating a web application requires a combination of HTML, CSS, JavaScript, and backend services. Creating an internationalized application requires additional techniques and libraries to provide and manage localized data formats and resources. This document concentrates on JavaScript needs.

Creating your own solutions is always a tempting option. However, I think a quicker and more reliable option for internationalization is to find and use an existing library. When picking a library, look for the following features:


* [Common Localization Data Repository](http://cldr.unicode.org/#TOC-What-is-CLDR-) (CLDR) usage
* EcmaScript Intl compatibility localized text support
* date, time, number, and currency format support
* sort and collation support
* pluralization, gender, complex message support
* phone number format support
* calendar options


In my opinion, using a single library that supports all of the above is preferable to using multiple libraries. However, one solution doesn't always work for every situation and a single solution doesn't even seem to exist. You may have to use two or more different libraries to get all the functionality you need. For example, libraries that provide general number formatting support typically don't provide phone number support.  

Considering the features above, you might consider these JavaScript internationalization libraries:

* [EcmaScript Intl](http://www.ecma-international.org/flat/publications/Standards/Ecma-402.htm)
* [Intl.js](https://github.com/andyearnshaw/Intl.js)
* [Globalize.js](https://github.com/jquery/globalize) 
* [Format.js](http://formatjs.io/)
* [LibPhoneNumber](https://code.google.com/p/libphonenumber/)

## EcmaScript Intl Library

EcmaScript, the language specification for JavaScript, has defined a new [Internationalization API](http://www.ecma-international.org/ecma-402/1.0/index.html). This API is already implemented in the Chrome browser, and may be partially implemented in other browsers as well. The Internationalization API defines a new namespace *Intl* that provides objects for the following:

* collation
* number formatting
* date/time formatting

The new Intl library is extremely important because it means that you get some  internationalization support without loading an external library. Additionally, implementations support the CLDR data, which is the best-practice for format patterns. When considering *any* other library, you should highly favor those that provide a poly-fill or proxy for this upcoming default library.

## Intl.js

The Intl.js library is a poly-fill for the EcmaScript Intl library. It provides the number and date/time formatting APIs. However, it does not provide the collation API. Because it used CLDR data, you can feel comfortable that the actual formats created by this library will be the same as the EcmaScript library. However, because collation isn't available, you obviously have to look elsewhere if that is needed. If you don't need collation, this may be a good option for basic data formatting.

## Globalize.js

The Globalize.js library now provides CLDR support. It also provides the expected number, date, and time formatting. However, it gives you a couple additional features above Intl.js that make it worth considering:
* message translation
* pluralization

Message translation is a localization API for common message strings. The library defines a file format for translatable message strings and gives you API for retrieving those strings after translation.

Pluralization is a feature that lets you accommodate the differences in word choice that are needed when word forms depend on their count. For example, the pluralization library let's you conveniently handle word choice for 0, 1, or n number of *mouse* or *mice*. Both Polish and Russian, for example, have several plural forms for 2, 3, 4, 5, or even more instances of a particular noun.

## Format.js

The Format.js library was recently released by Yahoo. It builds upon the Intl.js library and adds support for the following:

* template libraries like Handlebars, React, and Dust
* cache support for Intl format objects
* ICU message syntax for pluralization, gender, and other types of message variability
* relative time (5 min ago, 2 hours ago, etc)

## libphonenumber

The *libphonenumber* library solves a very specific need for phone number parsing and parsing. Your specific application may not need this, but if it does, you'll find most of what you need with this well-supported library from Google. In addition to JavaScript, the library exists for Java, C++, and other languages. The library helps you parse, format, and validate phone numbers for many countries of the world. Surprisingly, the library also helps you determin the type of  a phone number, for example, fixed-line, mobile, toll-free, etc.
 
 