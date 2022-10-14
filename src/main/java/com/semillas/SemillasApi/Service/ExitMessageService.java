package com.semillas.SemillasApi.Service;


import com.semillas.SemillasApi.Entities.ExitMessage;
import com.semillas.SemillasApi.Entities.Volunter;
import com.semillas.SemillasApi.Repository.ExitMessageRepository;
import com.semillas.SemillasApi.Repository.VolunterRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExitMessageService {
    @Inject
    ExitMessageRepository exitMessageRepository;

    @Inject
    VolunterRepository volunterRepository;

    public ExitMessage saveExitMessage(ExitMessage exitMessage){
        return exitMessageRepository.save(exitMessage);
    }

    public List<ExitMessage> getExitMessagesForVolunter(Long volunter_id){
        List<ExitMessage> exitMessageList=new ArrayList<>();
        Optional<Volunter> volunter=volunterRepository.findById(volunter_id);
        if (volunter!= null){
            exitMessageList= exitMessageRepository.findByVolunter(volunter.get());
        }
        return exitMessageList;
    }
}
