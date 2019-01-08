package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.repository.*;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.stream.Stream;
import lombok.*;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
@ToString

@NoArgsConstructor

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args); }

    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    ApplicationRunner init(MemberRepository memberRepository,InstrumentRepository instrumentRepository) {
        return args -> {

            Stream.of("Pam", "Diki", "Hero", "Save").forEach(Name -> {

            Member member = new Member();
            member.setName(Name);
            memberRepository.save(member);

            Member newPhone = new Member();

            if(Name == "Pam") {
                newPhone = memberRepository.findByName(Name);
                newPhone.setPhone("0811111111");
                memberRepository.save(newPhone);
            }else if(Name == "Diki") {
                newPhone = memberRepository.findByName(Name);
                newPhone.setPhone("0822222222");
                memberRepository.save(newPhone);
            }else if(Name == "Hero") {
                newPhone = memberRepository.findByName(Name);
                newPhone.setPhone("0833333333");
                memberRepository.save(newPhone);
            }else if(Name == "Save") {
                newPhone = memberRepository.findByName(Name);
                newPhone.setPhone("0844444444");
                memberRepository.save(newPhone);
            }

            });

            Stream.of("Electric Guitar Amp", "Electric Bass Amp", "Effect", "Loudspeaker","Drum","Guitar","Bass","Microphone").forEach(Nameins -> {
                Instrument instrument = new Instrument();
                instrument.setNameins(Nameins);
                instrumentRepository.save(instrument);

                Instrument newPrice = new Instrument();

                if(Nameins == "Electric Guitar Amp") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(200);
                    instrumentRepository.save(newPrice);
                }else if(Nameins == "Electric Bass Amp") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(200);
                    instrumentRepository.save(newPrice);
                }else if(Nameins == "Effect") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(300);
                    instrumentRepository.save(newPrice);
                }else if(Nameins == "Loudspeaker") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(100);
                    instrumentRepository.save(newPrice);
                }else if(Nameins == "Drum") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(500);
                    instrumentRepository.save(newPrice);
                }else if(Nameins == "Guitar") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(200);
                    instrumentRepository.save(newPrice);
                }else if(Nameins == "Bass") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(200);
                    instrumentRepository.save(newPrice);
                }else if(Nameins == "Microphone") {
                    newPrice = instrumentRepository.findByNameins(Nameins);
                    newPrice.setPrice(100);
                    instrumentRepository.save(newPrice);
                }



            });

            memberRepository.findAll().forEach(System.out::println);
            instrumentRepository.findAll().forEach(System.out::println);
        };


    }
}