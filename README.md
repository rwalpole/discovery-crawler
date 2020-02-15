# Discovery Crawler

*A tool to extract metadata terms from web pages*

This tool based on [crawler4j](https://github.com/yasserg/crawler4j) can crawl a website and extract text from webpages that are tagged in some way for example, if an HTML document contains an element like:

`<span class="item-title">Hello World!</span>`

It can extract the text "Hello World!" based on the `item-title` class for further analysis, perhaps by passing it to some semantic annotation tool such as Apache Stanbol.

The steps involved in this process are as follows:

1. Provide a seed URL for the crawl process to start.
2. The crawler creates a file of discovered URLs.
3. The URLs are read from the file and requested over HTTP. The resulting HTML is saved to file.
4. The HTML files are converted to XHTML using HTML Tidy.
5. An XPath reader extracts the tagged terms and creates a text file of the terms.