package com.autohome.autoracing.service.impl;

import com.autohome.autoracing.mapper.PlayerMapper;
import com.autohome.autoracing.pojo.Player;
import com.autohome.autoracing.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl extends BaseServiceImpl<Player> implements PlayerService {
    @Autowired
    public PlayerServiceImpl(PlayerMapper bodyworkMapper) {
        super(bodyworkMapper);
    }
}