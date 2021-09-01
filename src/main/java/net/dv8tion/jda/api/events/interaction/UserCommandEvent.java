package net.dv8tion.jda.api.events.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.commands.UserCommandInteraction;
import org.jetbrains.annotations.NotNull;

/**
 * Indicates that a user command was used on a {@link User}.
 *
 * <h2>Requirements</h2>
 * To receive these events, you must unset the <b>Interactions Endpoint URL</b> in your application dashboard.
 * You can simply remove the URL for this endpoint in your settings at the <a href="https://discord.com/developers/applications" target="_blank">Discord Developers Portal</a>.
 */
public class UserCommandEvent extends GenericCommandEvent implements UserCommandInteraction
{
    private final UserCommandInteraction commandInteraction;
    public UserCommandEvent(@NotNull JDA api, long responseNumber, @NotNull UserCommandInteraction interaction)
    {
        super(api, responseNumber, interaction);
        this.commandInteraction = interaction;
    }

    @Override
    public long getCommandIdLong()
    {
        return commandInteraction.getCommandIdLong();
    }

    @Override
    public long getInteractedIdLong()
    {
        return commandInteraction.getInteractedIdLong();
    }

    @NotNull
    @Override
    public User getInteractedUser()
    {
        return commandInteraction.getInteractedUser();
    }

    @Override
    public Member getInteractedMember()
    {
        return commandInteraction.getInteractedMember();
    }
}
