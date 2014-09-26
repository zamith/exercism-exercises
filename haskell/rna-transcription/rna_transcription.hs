module DNA(toRNA) where
import Data.Maybe

toRNA :: String -> String
toRNA = mapMaybe transcribe

transcribe :: Char -> Maybe Char
transcribe 'C' = Just 'G'
transcribe 'G' = Just 'C'
transcribe 'A' = Just 'U'
transcribe 'T' = Just 'A'
transcribe _ = Nothing
