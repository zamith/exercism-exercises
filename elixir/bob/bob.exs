defmodule Teenager do
  def hey(input) do
    cond do
      silence?(input) ->
        "Fine. Be that way!"
      question?(input) ->
        "Sure."
      shouting?(input) ->
        "Whoa, chill out!"
      true ->
        "Whatever."
    end
  end

  defp silence?(input) do
    input
    |> String.strip
    |> String.length == 0
  end

  defp question?(input) do
    input |> String.ends_with? "?"
  end

  defp shouting?(input) do
    input == String.upcase(input) && String.match?(input, ~r/[^\d, ]/)
  end
end
