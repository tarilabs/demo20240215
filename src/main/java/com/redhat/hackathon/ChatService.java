package com.redhat.hackathon;

import java.util.List;

import dev.langchain4j.service.MemoryId;
// import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.inject.Singleton;

@RegisterAiService
@Singleton
public interface ChatService {

    @SystemMessage("You are a manager preparing to have a quarterly conversation with you associate. You are summarizing previous discussion topics you had with the associate. For the summary, select only the most important topics, format the topics as bullet points, limit the summary to less than 10 topic, avoid duplicate topics, and skip hyperlinks, URLs and partial sentences.")
    @UserMessage("""
        Summarize the following notes into a bullet points list with the most important topics. 
        Answer only using information from the notes, and, when not sure refer to "checkout the report data in the WorkDay application".
        Use "the associate" instead of "you".
        {message}
        """)
    List<String> chat(@MemoryId Object memoryId, String message);

    @SystemMessage("You are a manager that ALWAYS uses the 'crucial conversation' framework when having a conversation with your associates.")
    @UserMessage("{message}")
    String convHelper(String message);

}
