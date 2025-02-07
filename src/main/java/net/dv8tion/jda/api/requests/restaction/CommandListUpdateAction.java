/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.requests.restaction;

import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.internal.utils.Checks;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

/**
 * Specialized {@link RestAction} used to replace existing commands of a guild or globally.
 * <br>Any commands that currently exist and are not listed through {@link #addCommands(CommandData...)} will be <b>DELETED</b>!
 */
public interface CommandListUpdateAction extends RestAction<List<Command>>
{
    @Nonnull
    @Override
    CommandListUpdateAction timeout(long timeout, @Nonnull TimeUnit unit);

    @Nonnull
    @Override
    CommandListUpdateAction deadline(long timestamp);

    @Nonnull
    @Override
    CommandListUpdateAction setCheck(@Nullable BooleanSupplier checks);

    @Nonnull
    @Override
    CommandListUpdateAction addCheck(@Nonnull BooleanSupplier checks);

    /**
     * Adds up to 100 {@link net.dv8tion.jda.api.interactions.commands.SlashCommand Slash Commands},
     * 5 {@link net.dv8tion.jda.api.interactions.commands.UserCommand User Commands},
     * and 5 {@link net.dv8tion.jda.api.interactions.commands.MessageCommand Message Commands}.
     * <p>When a command is not listed in this request, it will be deleted.
     *
     * @param  commands
     *         The {@link CommandData commands} to add
     *
     * @throws IllegalArgumentException
     *         If null or more than 100 Slash Commands or 5 User/Message commands are provided
     *
     * @return The CommandListUpdateAction instance, for chaining
     */
    @Nonnull
    @CheckReturnValue
    CommandListUpdateAction addCommands(@Nonnull Collection<? extends CommandData<?>> commands);

    /**
     * Adds up to 100 {@link net.dv8tion.jda.api.interactions.commands.SlashCommand Slash Commands},
     *      * 5 {@link net.dv8tion.jda.api.interactions.commands.UserCommand User Commands},
     *      * and 5 {@link net.dv8tion.jda.api.interactions.commands.MessageCommand Message Commands}.
     * <p>When a command is not listed in this request, it will be deleted.
     *
     * @param  commands
     *         The {@link CommandData commands} to add
     *
     * @throws IllegalArgumentException
     *         If null or more than 100 Slash Commands or 5 User/Message commands are provided
     *
     * @return The CommandListUpdateAction instance, for chaining
     */
    @Nonnull
    @CheckReturnValue
    default CommandListUpdateAction addCommands(@Nonnull CommandData<?>... commands)
    {
        Checks.noneNull(commands, "Command");
        return addCommands(Arrays.asList(commands));
    }
}
