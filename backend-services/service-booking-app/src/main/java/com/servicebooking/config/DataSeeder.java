package com.servicebooking.config;

import com.servicebooking.model.ServiceItem;
import com.servicebooking.repository.ServiceItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/*
    Automatically populates your 10 services from db.json into MySQL on startup if the services table is empty.
*/
@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedServices(ServiceItemRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    new ServiceItem("Web Development", "Tech", 500, 4.9, "Customized components built with modern UI Tech."),
                    new ServiceItem("Logo Design", "Design", 150, 4.8, "Stylist logo that define your business branding and identity."),
                    new ServiceItem("Content Writing", "Writing", 80, 4.7, "SEO optimized articles for your software products."),
                    new ServiceItem("Media Marketing", "Marketing", 300, 4.6, "Campaigns to boost your brand presence on social media."),
                    new ServiceItem("Mobile UI/UX", "Design", 400, 4.9, "User centric mobile UIs for high conversion and retention."),
                    new ServiceItem("Tech Automation", "Tech", 250, 4.5, "Custom scripts to automate your tasks."),
                    new ServiceItem("Video Editing Pro", "Design", 350, 4.8, "Quality cuts, transitions, and color grading for your videos."),
                    new ServiceItem("Ads Management", "Marketing", 200, 4.4, "Maximize your sales with campaigns."),
                    new ServiceItem("API Integration", "Tech", 600, 5.0, "Integrate your front end with APIs."),
                    new ServiceItem("Email Copywriting", "Writing", 120, 4.7, "Emails that turn subscribers into loyal customers fast.")
                ));
            }
        };
    }
}
