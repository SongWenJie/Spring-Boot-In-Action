package redinglistbymaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import redinglistbymaven.model.Book;
import redinglistbymaven.repositories.ReadingListRepository;

import java.util.List;


@Controller
@RequestMapping("/readinglist")
@ConfigurationProperties(prefix = "amazon")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    private String associateId;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository =readingListRepository;
    }

    public void setAssociateId(String associateId){
        this.associateId =associateId;
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader, Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null){
            model.addAttribute("books",readingList);
            model.addAttribute("associateId",associateId);
        }
        return "readingList";
    }


    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(
            @PathVariable("reader") String reader, Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readinglist/{reader}";
    }
}
