package com.reki.seu_blog.init;


import com.reki.seu_blog.domain.Authority;
import com.reki.seu_blog.domain.Category;
import com.reki.seu_blog.domain.User;
import com.reki.seu_blog.domain.UserAuthority;
import com.reki.seu_blog.features.category.CategoryRepository;
import com.reki.seu_blog.features.user.AuthorityRepository;
import com.reki.seu_blog.features.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    @PostConstruct
    public void dataInit() {
        if (categoryRepository.count() == 0) {
            List<Category> categories = new ArrayList<>();

            // Adding 50 categories using setters
            Category javaCategory = new Category();
            javaCategory.setName("Java");
            javaCategory.setDescription("Java programming language");
            categories.add(javaCategory);

            Category pythonCategory = new Category();
            pythonCategory.setName("Python");
            pythonCategory.setDescription("Python programming language");
            categories.add(pythonCategory);

            // Add remaining 48 categories similarly
            Category javascriptCategory = new Category();
            javascriptCategory.setName("JavaScript");
            javascriptCategory.setDescription("JavaScript for web development");
            categories.add(javascriptCategory);

            Category cppCategory = new Category();
            cppCategory.setName("C++");
            cppCategory.setDescription("C++ programming language");
            categories.add(cppCategory);

            Category csharpCategory = new Category();
            csharpCategory.setName("C#");
            csharpCategory.setDescription("C# programming language");
            categories.add(csharpCategory);

            Category rubyCategory = new Category();
            rubyCategory.setName("Ruby");
            rubyCategory.setDescription("Ruby programming language");
            categories.add(rubyCategory);

            Category phpCategory = new Category();
            phpCategory.setName("PHP");
            phpCategory.setDescription("PHP for server-side development");
            categories.add(phpCategory);

            Category goCategory = new Category();
            goCategory.setName("Go");
            goCategory.setDescription("Go programming language");
            categories.add(goCategory);

            Category rustCategory = new Category();
            rustCategory.setName("Rust");
            rustCategory.setDescription("Rust programming language");
            categories.add(rustCategory);

            Category kotlinCategory = new Category();
            kotlinCategory.setName("Kotlin");
            kotlinCategory.setDescription("Kotlin for Android and more");
            categories.add(kotlinCategory);

            Category swiftCategory = new Category();
            swiftCategory.setName("Swift");
            swiftCategory.setDescription("Swift for iOS development");
            categories.add(swiftCategory);

            Category typescriptCategory = new Category();
            typescriptCategory.setName("TypeScript");
            typescriptCategory.setDescription("TypeScript for typed JavaScript");
            categories.add(typescriptCategory);

            Category sqlCategory = new Category();
            sqlCategory.setName("SQL");
            sqlCategory.setDescription("Structured Query Language");
            categories.add(sqlCategory);

            Category nosqlCategory = new Category();
            nosqlCategory.setName("NoSQL");
            nosqlCategory.setDescription("Non-relational databases");
            categories.add(nosqlCategory);

            Category htmlCategory = new Category();
            htmlCategory.setName("HTML");
            htmlCategory.setDescription("HyperText Markup Language");
            categories.add(htmlCategory);

            Category cssCategory = new Category();
            cssCategory.setName("CSS");
            cssCategory.setDescription("Cascading Style Sheets");
            categories.add(cssCategory);

            Category reactCategory = new Category();
            reactCategory.setName("React");
            reactCategory.setDescription("React JavaScript library");
            categories.add(reactCategory);

            Category angularCategory = new Category();
            angularCategory.setName("Angular");
            angularCategory.setDescription("Angular framework");
            categories.add(angularCategory);

            Category vueCategory = new Category();
            vueCategory.setName("Vue.js");
            vueCategory.setDescription("Vue.js framework");
            categories.add(vueCategory);

            Category nodejsCategory = new Category();
            nodejsCategory.setName("Node.js");
            nodejsCategory.setDescription("Node.js runtime");
            categories.add(nodejsCategory);

            Category springCategory = new Category();
            springCategory.setName("Spring");
            springCategory.setDescription("Spring framework for Java");
            categories.add(springCategory);

            Category djangoCategory = new Category();
            djangoCategory.setName("Django");
            djangoCategory.setDescription("Django framework for Python");
            categories.add(djangoCategory);

            Category flaskCategory = new Category();
            flaskCategory.setName("Flask");
            flaskCategory.setDescription("Flask microframework");
            categories.add(flaskCategory);

            Category aspnetCategory = new Category();
            aspnetCategory.setName("ASP.NET");
            aspnetCategory.setDescription("ASP.NET framework");
            categories.add(aspnetCategory);

            Category devopsCategory = new Category();
            devopsCategory.setName("DevOps");
            devopsCategory.setDescription("Development and operations");
            categories.add(devopsCategory);

            Category cloudCategory = new Category();
            cloudCategory.setName("Cloud Computing");
            cloudCategory.setDescription("Cloud technologies");
            categories.add(cloudCategory);

            Category awsCategory = new Category();
            awsCategory.setName("AWS");
            awsCategory.setDescription("Amazon Web Services");
            categories.add(awsCategory);

            Category azureCategory = new Category();
            azureCategory.setName("Azure");
            azureCategory.setDescription("Microsoft Azure");
            categories.add(azureCategory);

            Category googleCloudCategory = new Category();
            googleCloudCategory.setName("Google Cloud");
            googleCloudCategory.setDescription("Google Cloud Platform");
            categories.add(googleCloudCategory);

            Category mlCategory = new Category();
            mlCategory.setName("Machine Learning");
            mlCategory.setDescription("Machine learning concepts");
            categories.add(mlCategory);

            Category aiCategory = new Category();
            aiCategory.setName("Artificial Intelligence");
            aiCategory.setDescription("AI technologies");
            categories.add(aiCategory);

            Category dataScienceCategory = new Category();
            dataScienceCategory.setName("Data Science");
            dataScienceCategory.setDescription("Data science and analytics");
            categories.add(dataScienceCategory);

            Category blockchainCategory = new Category();
            blockchainCategory.setName("Blockchain");
            blockchainCategory.setDescription("Blockchain technology");
            categories.add(blockchainCategory);

            Category cybersecurityCategory = new Category();
            cybersecurityCategory.setName("Cybersecurity");
            cybersecurityCategory.setDescription("Cybersecurity practices");
            categories.add(cybersecurityCategory);

            Category webDevCategory = new Category();
            webDevCategory.setName("Web Development");
            webDevCategory.setDescription("Web development topics");
            categories.add(webDevCategory);

            Category mobileDevCategory = new Category();
            mobileDevCategory.setName("Mobile Development");
            mobileDevCategory.setDescription("Mobile app development");
            categories.add(mobileDevCategory);

            Category gameDevCategory = new Category();
            gameDevCategory.setName("Game Development");
            gameDevCategory.setDescription("Game design and development");
            categories.add(gameDevCategory);

            Category uiuxCategory = new Category();
            uiuxCategory.setName("UI/UX");
            uiuxCategory.setDescription("User interface and experience");
            categories.add(uiuxCategory);

            Category testingCategory = new Category();
            testingCategory.setName("Testing");
            testingCategory.setDescription("Software testing techniques");
            categories.add(testingCategory);

            Category agileCategory = new Category();
            agileCategory.setName("Agile");
            agileCategory.setDescription("Agile methodologies");
            categories.add(agileCategory);

            Category scrumCategory = new Category();
            scrumCategory.setName("Scrum");
            scrumCategory.setDescription("Scrum framework");
            categories.add(scrumCategory);

            Category linuxCategory = new Category();
            linuxCategory.setName("Linux");
            linuxCategory.setDescription("Linux operating system");
            categories.add(linuxCategory);

            Category windowsCategory = new Category();
            windowsCategory.setName("Windows");
            windowsCategory.setDescription("Windows operating system");
            categories.add(windowsCategory);

            Category dockerCategory = new Category();
            dockerCategory.setName("Docker");
            dockerCategory.setDescription("Docker containerization");
            categories.add(dockerCategory);

            Category kubernetesCategory = new Category();
            kubernetesCategory.setName("Kubernetes");
            kubernetesCategory.setDescription("Kubernetes orchestration");
            categories.add(kubernetesCategory);

            Category microservicesCategory = new Category();
            microservicesCategory.setName("Microservices");
            microservicesCategory.setDescription("Microservices architecture");
            categories.add(microservicesCategory);

            Category algorithmsCategory = new Category();
            algorithmsCategory.setName("Algorithms");
            algorithmsCategory.setDescription("Algorithms and data structures");
            categories.add(algorithmsCategory);

            Category networkingCategory = new Category();
            networkingCategory.setName("Networking");
            networkingCategory.setDescription("Computer networking");
            categories.add(networkingCategory);

            Category databasesCategory = new Category();
            databasesCategory.setName("Databases");
            databasesCategory.setDescription("Database management");
            categories.add(databasesCategory);

            Category iotCategory = new Category();
            iotCategory.setName("IoT");
            iotCategory.setDescription("Internet of Things");
            categories.add(iotCategory);

            // Save all categories to the repository
            categoryRepository.saveAll(categories);
        }

        if (userRepository.count() == 0) {
            Authority user = new Authority();
            user.setName("USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setName("ADMIN");
            authorityRepository.save(admin);


            User newUser = new User();
            newUser.setUsername("admin");
            newUser.setPassword(passwordEncoder.encode("admin"));

            newUser.setEmail("admin@admin.com");
            newUser.setEmailVerified(true);
            newUser.setIsEnabled(true);
            newUser.setAccountNonLocked(true);
            newUser.setAccountNonExpired(true);
            newUser.setCredentialsNonExpired(true);
            newUser.setAvatar("https://static.vecteezy.com/system/resources/thumbnails/019/194/935/small_2x/global-admin-icon-color-outline-vector.jpg");
            newUser.setIsDeleted(false);


            UserAuthority adminAuthority = new UserAuthority();
            adminAuthority.setUser(newUser);
            adminAuthority.setAuthority(admin);

            newUser.setAuthority(Set.of(adminAuthority));


            userRepository.save(newUser);


        }

    }
}
