The _java.time.LocalDate_ class is new in Java 8. Inspired by the _Joda Time_ library, LocalDate represents a date as it might be used from a wall calendar. It is not a singular instant in time like _java.util.Date_. You might use a LocalDate to represent a birthday, the start of a school year, or an anniversary. LocalDate text representations are familiar. They look like "2014-10-09" or "October 9, 2014" or other similar user-friendly text.

### How do I create a LocalDate? 

Create a LocalDate with any of its several static creation methods. I won't cover all the ways here but will show you three methods, one of which requires close attention.

### Give it to me now!
Want a LocalDate now? Here's how you do it (assume I'm in Los Angeles CA):

    LocalDate todayInLA = LocaleDate.now();
    
LocalDate will provide a text string formatted in ISO `YYYY-MM-dd` format if you call its `toString` method:
 
    String formattedDate = todayInLA.toString();

This will create text like this:

    2014-10-09
    
You should know this fact about `now()`. It uses your computer's default time zone to retrieve now's date. So, a computer in Los Angeles (USA) and a computer in Dublin (Ireland) could execute this same method at the same time and produce two different calendar dates. It's only reasonable they should. After all, they would be in different time zones.

If you want to be specific about the time zone used when creating the local date, use the over-loaded method with a time zone:

    ZoneId zoneDublin = ZoneId.of("Europe/Dublin");
    LocalDate todayInDublin = LocalDate.now(zoneDublin);
    
Executed at exactly the same time as the previous `now` method, this time zone-aware method could return the following:

    2014-10-10

### I want a specific date
You can be more specific about your date too. You can ask for a date for a specific year, month, and day. This creates a LocalDate that is the same regardless of time zone. For example, let's create a local date for Halloween (celebrated on October 31 for those areas that celebrate the holiday):

    LocalDate halloween = LocalDate.of(2014, 10, 31);
    
The `toString` method produces this:

    2014-10-31
    
### Can I format the LocaleDate differently?
Of course you can! You'll need the `format` method for that. The `format` method uses a `DateTimeFormatter` that understands locale-sensitive preferences for printed dates.

You can learn about the `format` method and more from the [LocalDate Javadocs](http://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html). 