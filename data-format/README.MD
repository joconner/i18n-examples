Build this project with the following:

    mvn clean assembly:assembly

Then run from the target directory with the following:

    java -jar data-format-1.0-SNAPSHOT-jar-with-dependencies.jar

You may provide any (or none) of the following options:

    -l <locale id>
    -c <currency id>
    -t <time zone id>

A <locale id> has the form <lang>-<region>, where <lang> is an ISO 636 language 
code and <region> is a valid ISO 3166 region code. The DEFAULT is en-US.

Some example locale ids:
* en-US
* hi-IN
* fr-FR
* en-CA
* fr-CA

A valid <currency id> is an ISO 4217 code such as the following:
* USD
* EUR
* INR

The DEFAULT currency is USD.

A valid <time zone id> is an Olson time zone id. You can see the wikipedia 
(http://en.wikipedia.org/wiki/List_of_tz_database_time_zones)
entry for this. However, some valid identifiers include:
* America/Los_Angeles
* Bangalore/India
* New York/New York

The default time zone is America/Los_Angeles.

Running with options, your command-line might look like any of these:
* java -jar data-format-1.0-SNAPSHOT-jar-with-dependencies.jar -l hi-IN -c INR -t Bangalore/India

Running the above options, the output will look similar to this:

Date: २४ फ़रवरी, २०१५
Number: १२३,४५६,७८९
Currency: रू १२३,४५६,७८९.००

