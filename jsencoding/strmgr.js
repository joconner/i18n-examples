/**
 * Created by john.oconner on 9/22/14.
 */


var StringMgr = (function () {
    var _RESOURCE = {};

    function isString(value) {
        return typeof value === "string" || value instanceof String;
    }

    function addStrings(map) {
        Object.keys(map).forEach(function (key) {
            if (isString(map[key])) {
                _RESOURCE[key] = map[key];
            }
        });
    }

    function getString(key) {
        return _RESOURCE[key];
    }

    function getKeys() {
        return Object.keys(_RESOURCE).sort();
    }

    return {
        addStrings: addStrings,
        getString: getString,
        getKeys: getKeys
    };
})();
