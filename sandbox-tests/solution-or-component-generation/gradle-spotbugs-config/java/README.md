**Configure Gradle Spotbugs plugin**

*Test Description*:

A developer is trying to configure Spotbugs plugin in build.gradle script

*Act*

<details>
<summary>Code Completion instructions:</summary>

- Open the project solution-or-component-generation/spring-boot/java
- Open the build.gradle file
- Move to `plugins` sections, enter the comment

```
//spotbugs
```

- Press Enter
- Accept the best suggested implementation using the TAB and ENTER keys
- Go to the line before `eclipse` section, enter the comment

```
// configure spotbugs to generate HTML and XML reports
```

- Press Enter
- Accept the best suggested implementation using the TAB and ENTER keys
- Open gradle.properties file
- Enter on a new line

```
rev_spotbugs=
```

- Press Enter
- Accept the best suggested implementation using the TAB and ENTER keys

</details>

*Assert conditions*

- Verify the plugin is defined as:

```groovy
plugins {
    id 'com.github.spotbugs' version "$rev_spotbugs"
}
```

- Verify the Spotbugs reports are configured as:

```groovy
spotbugsMain {
    reports {
        html.enabled = true
        xml.enabled = true
    }
}

spotbugsTest {
    reports {
        html.enabled = true
        xml.enabled = true
    }
}
```
- Verify the Spotbugs revision is defined as:

```
rev_spotbugs=6.0.26
```

- Build the project with the command `gradle build`
- List build/reports/spotbugs/ directory and check the following files exist:

```
main.html
main.xml
test.html
test.xml
```
