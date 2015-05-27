// configure the require library
requirejs.config({
    paths: {
        "jquery": "libs/jquery-2.1.4.min",
        "i18n": "libs/i18n"
    },
    config: {
        i18n: {
            locale: "en"
        }
    }
});


// declare dependencies on the jquery library and the i18n plugin for the "text" bundle
define(["jquery", "i18n!nls/text"],  function($, text) {

    // pull the text from the bundle and insert it into the document
    $("#titleTxt").append(text.titleTxt);
    $("#headerTxt").append(text.headerTxt);
    $("#quoteTxt").append(text.quoteTxt);
    $("#authorTxt").append(text.authorTxt);

});

